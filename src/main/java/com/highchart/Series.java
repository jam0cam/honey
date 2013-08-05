package com.highchart;

import java.util.List;

/**
 * User: jitse
 * Date: 8/2/13
 * Time: 1:18 PM
 */
public class Series {

    private String seriesType = "column";
    private List<Integer> myData;
    private String name;

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMyData() {
        return myData;
    }

    public void setMyData(List<Integer> myData) {
        this.myData = myData;
    }
}
