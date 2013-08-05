package com.highchart;

import java.util.List;

/**
 * User: jitse
 * Date: 8/3/13
 * Time: 12:16 PM
 */
public class PieData {

    private List<List<Object>> data;
    private String name;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }
}
