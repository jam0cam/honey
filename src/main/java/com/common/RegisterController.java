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
 * Date: 6/16/13
 * Time: 7:06 PM
 */
@Controller
@RequestMapping("/register")
public class RegisterController
{
    @Autowired
    Dao dao;

    @Autowired
    MyUserContext myUserContext;

    @Autowired
    RegisterValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        return new ModelAndView("common/register", "command", new User());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("command")User command, BindingResult result) {

        validator.validate(command, result);

        if (!result.hasErrors()){

            Util.trimRegister(command);

            dao.insertRegistration(command);

            myUserContext.authenticateAndSetUser(command);
            return new ModelAndView("redirect:/home");
        } else {
            return new ModelAndView("common/register", "command", command);
        }


    }

}
