package com.finance.validator;

import com.finance.dao.EntryDao;
import com.finance.model.EntryCommand;
import com.security.MyUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * User: jitse
 * Date: 6/28/13
 * Time: 9:23 PM
 */
@Component
public class EntryValidator implements Validator {

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private MyUserContext myUserContext;


    @Override
    public boolean supports(Class<?> aClass) {
        return EntryCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EntryCommand command = (EntryCommand)o;

        if (!StringUtils.hasText(command.getAmount())) {
            errors.rejectValue("amount", "amount.required");
        } else {
            try {
                Double.parseDouble(command.getAmount());
            } catch (Exception e){
                errors.rejectValue("amount", "amount.invalid");
            }
        }

        if (command.getDate() == null) {
            errors.rejectValue("date", "date.required");
        }

        if (!StringUtils.hasText(command.getNotes())) {
            if (command.getNotes().length() > 120) {
                errors.rejectValue("note", "notes.length.exceeded");
            }
        }
    }

    public boolean isValidForEdit(String entryId) {
        EntryCommand entry = entryDao.getEntryById(entryId);

        if (entry == null) {
            return false;
        } else if (entry.getPayee().getUserId().equals(myUserContext.getCurrentUser().getId())) {
            return true;
        } else  {
            return false;
        }
    }
}
