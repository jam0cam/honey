package com.coupon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: jitse
 * Date: 7/20/13
 * Time: 1:52 PM
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        return new ModelAndView("coupon/coupon");
    }
}
