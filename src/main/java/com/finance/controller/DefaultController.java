package com.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: jitse
 * Date: 7/20/13
 * Time: 1:31 PM
 */
@Controller
@RequestMapping("/finance")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        return new ModelAndView("redirect:/finance/account");
    }
}
