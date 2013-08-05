package com.finance.model;

import java.util.List;

/**
 * User: jitse
 * Date: 6/23/13
 * Time: 11:00 AM
 */
public class HistoryCommand {

    private String name;
    private List<RowData> rowdata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RowData> getRowdata() {
        return rowdata;
    }

    public void setRowdata(List<RowData> rowdata) {
        this.rowdata = rowdata;
    }
}
