package com.finance.controller;

import com.finance.dao.EntryDao;
import com.finance.dao.PayeeDao;
import com.finance.model.EntryCommand;
import com.finance.model.Payee;
import com.security.MyUserContext;
import com.common.Util;
import com.finance.validator.EntryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: jitse
 * Date: 6/18/13
 * Time: 4:37 PM
 */
@Controller
@RequestMapping("/finance/entry")
public class EntryController {

    @Autowired
    PayeeDao payeeDao;

    @Autowired
    EntryDao entryDao;

    @Autowired
    private MyUserContext myUserContext;

    @Autowired
    private EntryValidator validator;

    /**
     * This returns the page to add a new entry
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {

        EntryCommand command = new EntryCommand();
        command.setPayees(getPayees());

        return new ModelAndView("finance/entry", "command", command);
    }

    @RequestMapping(value="/edit/id/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView edit (@PathVariable("id") String id, @RequestParam(value="returnTo", required = false) String returnTo) {
        if (!validator.isValidForEdit(id)) {
            if (returnTo.equals("history")) {
                return new ModelAndView("redirect:/finance/history");
            } else {
                return new ModelAndView("redirect:/finance/account");
            }

        }

        EntryCommand command = entryDao.getEntryById(id);
        command.setPayees(getPayees());
        command.setReturnTo(returnTo);
        command.setSelectedPayeeId(command.getPayee().getId());

        return new ModelAndView("finance/entry", "command", command);
    }

    private Map<String, String> getPayees() {
        Map<String, String> payees = new HashMap<String, String>();

        List<Payee> list = payeeDao.getAllPayees(myUserContext.getCurrentUser().getId());

        for (Payee p : list) {
            payees.put(p.getId(), p.getName());
        }

        return payees;
    }

    @InitBinder
    public void registerDateBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("command") EntryCommand command, BindingResult result) {

        validator.validate(command, result);
        if (result.hasErrors()) {
            command.setPayees(getPayees());
            return new ModelAndView("finance/entry", "command", command);
        } else {
            Util.trimEntry(command);

            if (StringUtils.hasText(command.getId())) { //do an update
                entryDao.updateEntry(command);
            } else {
                entryDao.addEntry(command);
            }

            if (command.getReturnTo().equals("history")) {
                return new ModelAndView("redirect:/finance/history");
            } else {
                return new ModelAndView("redirect:/finance/account");
            }
        }
    }
}
