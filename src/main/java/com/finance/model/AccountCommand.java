package com.finance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 6/18/13
 * Time: 12:33 PM
 */
public class AccountCommand implements Serializable {

    private String name;
    List<RowData> rowDatas = new ArrayList<RowData>();
    List<RowData> rowTitles = new ArrayList<RowData>();
    private boolean hasPayees;


    public boolean isHasPayees() {
        return hasPayees;
    }

    public void setHasPayees(boolean hasPayees) {
        this.hasPayees = hasPayees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RowData> getRowDatas() {
        return rowDatas;
    }

    public void setRowDatas(List<RowData> rowDatas) {
        this.rowDatas = rowDatas;
    }

    public List<RowData> getRowTitles() {
        return rowTitles;
    }

    public void setRowTitles(List<RowData> rowTitles) {
        this.rowTitles = rowTitles;
    }
}
