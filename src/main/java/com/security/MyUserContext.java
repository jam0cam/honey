package com.security;

import com.common.Dao;
import com.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * User: jitse
 * Date: 6/20/13
 * Time: 7:08 PM
 */
@Component
public class MyUserContext {

    @Autowired
    private Dao dao;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public void setCurrentUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                user.getPassword(),userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * This is used when registering new accounts. We will authenticate the user and set it in the security context.
     */
    public void authenticateAndSetUser(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getPassword());
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal().getClass().isInstance("java.lang.String")) {
            return null;
        }

        String email = ((User)authentication.getPrincipal()).getEmail();
        return dao.getByEmail(email);
    }
}
