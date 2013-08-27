package com.finance.controller;

import com.common.User;
import com.finance.dao.EntryDao;
import com.finance.model.DeleteObject;
import com.finance.model.EntryCommand;
import com.finance.model.HistoryCommand;
import com.finance.model.RowData;
import com.finance.validator.DeleteEntryValidator;
import com.security.MyUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 6/23/13
 * Time: 10:52 AM
 */
@Controller
@RequestMapping("/finance/history")
public class HistoryController {
    @Autowired
    private MyUserContext myUserContext;

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private DeleteEntryValidator validator;

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        User user = myUserContext.getCurrentUser();
        List<EntryCommand> entries =  entryDao.getEntriesByUserId(user.getId());

        List<HistoryCommand> command = new ArrayList<HistoryCommand>();

        String currentPayeeId = "0";
        for (EntryCommand entry : entries) {
            if (!currentPayeeId.equals(entry.getPayee().getId())) {
                currentPayeeId = entry.getPayee().getId();
                HistoryCommand hc = new HistoryCommand();

                hc.setName(entry.getPayee().getName());
                hc.setRowdata(getRowDatas(currentPayeeId, entries));
                command.add(hc);
            }
        }

        return new ModelAndView("finance/history", "command" , command);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remove/id/{id}")
    public @ResponseBody
    ModelAndView remove (@PathVariable("id") String id) {
        if (validator.isValid(id)) {
            entryDao.deleteEntry(new DeleteObject(id));
        }

        return new ModelAndView("redirect:/finance/history");
    }

    private List<RowData> getRowDatas(String payeeId, List<EntryCommand> entries) {


        List<RowData> rval = new ArrayList<RowData>();

        for (EntryCommand entry : entries) {
            if (payeeId.equals(entry.getPayee().getId())){
                RowData row = new RowData();
                row.setName("$" + entry.getAmount());
                row.setMonth1(formatter.format(entry.getDate()));
                row.setMonth2(entry.getNotes());
                row.setId(entry.getId());
                rval.add(row);
            }
        }

        return rval;
    }


}
