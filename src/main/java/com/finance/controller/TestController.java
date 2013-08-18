package com.finance.controller;

import com.finance.model.EntryCommand;
import com.highchart.AxisData;
import com.highchart.GraphData;
import com.highchart.Series;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * User: jitse
 * Date: 6/18/13
 * Time: 11:13 AM
 */
@Controller
@RequestMapping("/finance/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        return new ModelAndView("test");
    }


    @RequestMapping(value="/test", method = RequestMethod.GET)
    public @ResponseBody
    String test () {
        return "Helo world";
    }

    @RequestMapping(value="/data", method = RequestMethod.GET)
    public @ResponseBody
    GraphData getData () {

        Integer[] val = {5,10,15,20};
        Integer[] val2 = {15,20,35,40};
        String[] val3 = {"Jan.", "Feb.", "Mar.", "Apr."};

        List<Integer> values = Arrays.asList(val);

        GraphData data = new GraphData();

        Series series = new Series();
        series.setMyData(values);
        series.setName("Matt");

        Series series2 = new Series();
        series2.setMyData(Arrays.asList(val2));
        series2.setName("Jia");

        data.getSeries().add(series);
        data.getSeries().add(series2);

        AxisData xAxis = new AxisData();
        xAxis.setData(Arrays.asList(val3));

        data.setxAxis(xAxis);
        data.setyTitle("Total Wins");
        return data;
    }

    @RequestMapping(value="/data2", method = RequestMethod.GET)
    public @ResponseBody
    GraphData getData2 () {

        Integer[] val = {5,10,15,20};
        Integer[] val2 = {50,60,70,80};
        String[] val3 = {"Jan.", "Feb.", "Mar.", "Apr."};

        List<Integer> values = Arrays.asList(val);

        GraphData data = new GraphData();

        Series series = new Series();
        series.setMyData(values);
        series.setName("Matt");

        Series series2 = new Series();
        series2.setMyData(Arrays.asList(val2));
        series2.setName("Jia");

        data.getSeries().add(series);
        data.getSeries().add(series2);

        AxisData xAxis = new AxisData();
        xAxis.setData(Arrays.asList(val3));

        data.setxAxis(xAxis);
        data.setyTitle("Total Wins");
        return data;
    }

    public static void main(String[] args) throws Exception {
        String userId = "1";

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        System.out.println(om.writeValueAsString(new EntryCommand()));


    }
}
