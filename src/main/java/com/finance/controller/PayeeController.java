package com.finance.controller;

import com.finance.dao.PayeeDao;
import com.finance.model.Payee;
import com.common.User;
import com.security.MyUserContext;
import com.common.Util;
import com.finance.validator.PayeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * User: jitse
 * Date: 6/21/13
 * Time: 10:18 AM
 */
@Controller
@RequestMapping("/finance/payee")
public class PayeeController {

    @Autowired
    private PayeeDao payeeDao;

    @Autowired
    private PayeeValidator validator;

    @Autowired
    private MyUserContext myUserContext;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        User user = myUserContext.getCurrentUser();
        List<Payee> payees =  payeeDao.getAllPayees(user.getId());

        return new ModelAndView("finance/payee", "command" , payees);

    }

    @RequestMapping(value = "/add",  method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addPayee () {
        Payee command = new Payee();
        return new ModelAndView("finance/payeeForm", "command", command);
    }

    @RequestMapping(value = "/update/id/{id}",  method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView updatePayee (@PathVariable("id") String id) {

        String userId = myUserContext.getCurrentUser().getId();
        Payee payee = payeeDao.getPayeeById(id);

        //user not authorize to see this payee
        if (payee == null || !payee.getUserId().equals(userId)){
            return new ModelAndView("redirect:/finance/payee");
        }

        return new ModelAndView("finance/payeeForm", "command", payee);
    }

    @RequestMapping(value= "/save", method=RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("command")Payee command, BindingResult result) {
        String userId = myUserContext.getCurrentUser().getId();

        Util.trimPayee(command);

        validator.validate(command, result);

        if (result.hasErrors()) {
            return new ModelAndView("finance/payeeForm", "command", command);
        } else {
            command.setUserId(userId);

            if (!command.isNotifyOn() && !StringUtils.hasText(command.getNotifyDay())) {
                //defaulting to a value that doesn't matter
                command.setNotifyDay("1");
            }

            //if there is a id, then we update, otherwise we add
            if (!StringUtils.hasText(command.getId())) {
                payeeDao.addPayee(command);
            } else {
                payeeDao.update(command);
            }

            return new ModelAndView("redirect:/finance/payee");
        }
    }

    @RequestMapping(value = "/remove/id/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView remove (@PathVariable("id") String id) {
        if (validator.isValidForDelete(id)) {
            payeeDao.deletePayee(id);
        }

        return new ModelAndView("redirect:/finance/payee");
    }

}
