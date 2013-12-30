package com.finance.controller;

import com.common.User;
import com.finance.dao.EntryDao;
import com.finance.dao.PayeeDao;
import com.finance.model.*;
import com.security.MyUserContext;
import com.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * User: jitse
 * Date: 6/16/13
 * Time: 7:49 PM
 */
@Controller
@RequestMapping("/finance/account")
public class AccountController {

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private PayeeDao payeeDao;

    @Autowired
    private MyUserContext myUserContext;

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        User user = myUserContext.getCurrentUser();

        if (user == null) {
            return new ModelAndView("redirect:/");
        }

        List<EntryCommand> entries = entryDao.getEntriesByUserId(user.getId());

        AccountCommand command = new AccountCommand();
        command.setName(user.getName());


        if (entries != null && !entries.isEmpty()) {

            Date today = new Date();
            command.setHasPayees(true);

            //title row
            RowData data = new RowData();
            data.setName("Name");
            data.setMonth1(Util.getMonthName(today.getMonth() + 2));
            data.setMonth2(Util.getMonthName(today.getMonth() + 1));
            data.setMonth3(Util.getMonthName(today.getMonth()));
            data.setMonth4(Util.getMonthName(today.getMonth() - 1));
            command.getRowTitles().add(data);

            String currentPayeeId = "0";
            for (EntryCommand entry : entries) {
                if (!currentPayeeId.equals(entry.getPayee().getId())) {
                    currentPayeeId = entry.getPayee().getId();
                    command.getRowDatas().add(getRowData(currentPayeeId, entries));
                }
            }

        }

        //If we don't have a payee at this point, we'll check to see if there is payees set in the db
        if (!command.isHasPayees()) {
            List<Payee> payees = payeeDao.getAllPayees(user.getId());
            if (payees != null && !payees.isEmpty()) {
                command.setHasPayees(true);
            }
        }

        return new ModelAndView("finance/account", "command", command);
    }

    private RowData getRowData(String payeeId, List<EntryCommand> entries) {
        RowData row = new RowData();
        Date today = new Date();

        for (EntryCommand entry : entries) {
            if (payeeId.equals(entry.getPayee().getId())){
                if (row.getName() == null) {
                    row.setName(entry.getPayee().getName());
                    row.setUrl(entry.getPayee().getUrl());
                }
                if (Util.getMonthName(today.getMonth()+2).equals(Util.getMonthName(entry.getDate().getMonth()+1))) {
                    row.setToolTip1(formatter.format(entry.getDate()));
                    row.setMonth1("$" + entry.getAmount());
                    row.setEntryId1(entry.getId());
                } else if (Util.getMonthName(today.getMonth()+1).equals(Util.getMonthName(entry.getDate().getMonth()+1))) {
                    row.setToolTip2(formatter.format(entry.getDate()));
                    row.setMonth2("$" + entry.getAmount());
                    row.setEntryId2(entry.getId());
                } else if (Util.getMonthName(today.getMonth()).equals(Util.getMonthName(entry.getDate().getMonth()+1))) {
                    row.setToolTip3(formatter.format(entry.getDate()));
                    row.setMonth3("$" + entry.getAmount());
                    row.setEntryId3(entry.getId());
                } else if (Util.getMonthName(today.getMonth()-1).equals(Util.getMonthName(entry.getDate().getMonth()+1))) {
                    row.setToolTip4(formatter.format(entry.getDate()));
                    row.setMonth4("$" + entry.getAmount());
                    row.setEntryId4(entry.getId());
                }
            }
        }

        return row;
    }

}
