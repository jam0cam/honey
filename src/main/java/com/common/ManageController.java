package com.common;

import com.security.MyUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: jitse
 * Date: 6/28/13
 * Time: 2:54 PM
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private MyUserContext myUserContext;

    @Autowired
    private Dao dao;

    @Autowired
    private ManageValidator validator;

    @RequestMapping(method = RequestMethod.GET)
         public @ResponseBody
         ModelAndView main () {
        User user = myUserContext.getCurrentUser();

        if (user == null) {
            return new ModelAndView("redirect:/");
        }
        LoginCommand command = new LoginCommand();
        command.setEmail(user.getEmail());

        return new ModelAndView("common/manage", "command", command);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView onSubmit(@ModelAttribute("command")LoginCommand command, BindingResult result) {
        User user = myUserContext.getCurrentUser();

        validator.validate(command, result);

        if (result.hasErrors()) {
            return new ModelAndView("common/manage", "command", command);
        } else {
            command.setId(user.getId());
            dao.updatePassword(command);
            return new ModelAndView("redirect:/home");
        }

    }
}
