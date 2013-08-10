package com.taichi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: jitse
 * Date: 8/6/13
 * Time: 4:50 PM
 */
@Controller
@RequestMapping("/taichi")
public class TaiChiController {


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView stats () {
        return new ModelAndView("taichi/taichi");
    }

    @RequestMapping(value="/nineAspects",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView nineAspects () {

        return new ModelAndView("taichi/nineAspects");
    }

    @RequestMapping(value="/lectures",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView lectures () {
        return new ModelAndView("taichi/lectures");
    }

    @RequestMapping(value="/health",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView health () {
        return new ModelAndView("taichi/health");
    }

    @RequestMapping(value="/forms",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView forms () {
        return new ModelAndView("taichi/forms");
    }

    @RequestMapping(value="/eightPrinciples",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView eightPrinciples () {

        return new ModelAndView("taichi/eightPrinciples");
    }

}
