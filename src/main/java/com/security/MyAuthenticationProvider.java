package com.security;

import com.common.Dao;
import com.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * User: jitse
 * Date: 6/21/13
 * Time: 7:26 PM
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    Dao dao;

    @Autowired
    MyUserContext myUserContext;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String email = token.getName();
        String password = token.getCredentials().toString();

        User user =  dao.getByEmailAndPassword(email, password);

        if(user == null) {
            throw new BadCredentialsException("Invalid username/password");
        }
        myUserContext.setCurrentUser(user);
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
