package com.common;

import com.common.Dao;
import com.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * User: jitse
 * Date: 6/29/13
 * Time: 11:08 PM
 */
@Component
public class RegisterValidator implements Validator {

    @Autowired
    Dao dao;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User command = (User)o;

        if (!StringUtils.hasText(command.getPassword())) {
            errors.rejectValue("password", "password.required");
        }

        if (!StringUtils.hasText(command.getName())) {
            errors.rejectValue("name", "name.required");
        }

        if (!StringUtils.hasText(command.getPassword())) {
            errors.rejectValue("email", "email.required");
        }

        if (dao.getByEmail(command.getEmail()) != null) {
            errors.rejectValue("email", "email.taken" );
        }
    }
}
