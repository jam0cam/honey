package com.highchart;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 8/2/13
 * Time: 9:05 AM
 */
public class GraphData {

    List<Series> series = new ArrayList<Series>();
    AxisData xAxis = new AxisData();
    private String yTitle;
    private PieData pieData;
    private String chartTitle;

    public String getChartTitle() {
        return chartTitle;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
    }

    public PieData getPieData() {
        return pieData;
    }

    public void setPieData(PieData pieData) {
        this.pieData = pieData;
    }

    public String getyTitle() {
        return yTitle;
    }

    public void setyTitle(String yTitle) {
        this.yTitle = yTitle;
    }

    public AxisData getxAxis() {
        return xAxis;
    }

    public void setxAxis(AxisData xAxis) {
        this.xAxis = xAxis;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
