package com.finance.validator;

import com.finance.dao.EntryDao;
import com.finance.model.EntryCommand;
import com.common.User;
import com.security.MyUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: jitse
 * Date: 6/30/13
 * Time: 12:09 PM
 */
@Component
public class DeleteEntryValidator{
    @Autowired
    private EntryDao entryDao;

    @Autowired
    private MyUserContext myUserContext;

    /**
     * Validates that the current user can delete the entry id passed in.
     * @param entryId
     */
    public boolean isValid(String entryId) {
        User user = myUserContext.getCurrentUser();

        EntryCommand entry = entryDao.getEntryById(entryId);

        try{
            if (!entry.getPayee().getUserId().equals(user.getId())) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
