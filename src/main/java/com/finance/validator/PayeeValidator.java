package com.finance.validator;

import com.finance.dao.PayeeDao;
import com.finance.model.Payee;
import com.common.User;
import com.security.MyUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * User: jitse
 * Date: 6/28/13
 * Time: 10:05 PM
 */
@Component
public class PayeeValidator implements Validator {
    @Autowired
    private PayeeDao payeeDao;

    @Autowired
    private MyUserContext myUserContext;

    @Override
    public boolean supports(Class<?> aClass) {
        return Payee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Payee command = (Payee)o;

        if (!StringUtils.hasText(command.getName())) {
            errors.rejectValue("name", "name.required");
        }

        if (StringUtils.hasText(command.getNotes())) {
            if (command.getNotes().length() > 120) {
                errors.rejectValue("notes", "notes.length.exceeded");
            }
        }

        //If there is a date given, the date must be valid
        if (StringUtils.hasText(command.getNotifyDay())) {
            try{
                int value = Integer.parseInt(command.getNotifyDay());
                if (value > 28 || value < 1) {
                    errors.rejectValue("notifyDay", "invalid.day.range");
                }
            } catch (Exception e) {
                errors.rejectValue("notifyDay", "invalid.day.format");
            }
        }

        //if notification is turned on, then we must need a date
        if (command.isNotifyOn() && !StringUtils.hasText(command.getNotifyDay())) {
            errors.rejectValue("notifyDay", "day.required");
        }


        if (!StringUtils.hasText(command.getId())) {  //this is a new insert
            if (payeeDao.getPayeeByName(command.getName(), myUserContext.getCurrentUser().getId()) != null){
                errors.rejectValue("name", "payee.exists");
            }
        } else {  //this is an update, so verify that logged in user can
            Payee payee = payeeDao.getPayeeById(command.getId());

            if (payee == null){
                errors.rejectValue("name", "invalid.request");
            } else if (!payee.getUserId().equals(myUserContext.getCurrentUser().getId())) {
                errors.rejectValue("name", "invalid.request");
            }

        }
    }

    public boolean isValidForDelete(String payeeId) {
        User user = myUserContext.getCurrentUser();
        Payee payee = payeeDao.getPayeeById(payeeId);

        try{
            if (payee.getUserId().equals(user.getId())){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
