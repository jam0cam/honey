package com.common;

import com.common.LoginCommand;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * User: jitse
 * Date: 6/28/13
 * Time: 9:06 PM
 */
@Component
public class ManageValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LoginCommand command = (LoginCommand)o;

        if (!StringUtils.hasText(command.getPassword())) {
            errors.rejectValue("password", "password.required");
        }

    }
}
