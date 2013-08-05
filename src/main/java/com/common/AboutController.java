package com.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: jitse
 * Date: 7/20/13
 * Time: 9:48 AM
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private Dao dao;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        return new ModelAndView("common/about", "command", new About());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("command")About command, BindingResult result) {

        if (!StringUtils.hasText(command.getEmail())) {
            result.rejectValue("email", "email.required");
        }

        if (command.getComments().length() > 32) {
            result.rejectValue("email", "email.length.exceeded");
        }

        if (!StringUtils.hasText(command.getComments())) {
            result.rejectValue("comments", "comment.required");
        }

        if (command.getComments().length() > 255) {
            result.rejectValue("comments", "comment.length.exceeded");
        }

        if (result.hasErrors()) {
            return new ModelAndView("common/about", "command", command);
        } else {
            dao.insertComments(command);
            return new ModelAndView("common/aboutSuccess");
        }
    }

}
