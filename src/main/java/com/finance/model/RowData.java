package com.finance.model;

import java.io.Serializable;

/**
 * User: jitse
 * Date: 6/18/13
 * Time: 12:45 PM
 */
public class RowData implements Serializable {
    private String id;
    private String name;
    private String month1;
    private String month2;
    private String month3;
    private String toolTip1;
    private String toolTip2;
    private String toolTip3;

    private String entryId1;
    private String entryId2;
    private String entryId3;

    public String getEntryId1() {
        return entryId1;
    }

    public void setEntryId1(String entryId1) {
        this.entryId1 = entryId1;
    }

    public String getEntryId2() {
        return entryId2;
    }

    public void setEntryId2(String entryId2) {
        this.entryId2 = entryId2;
    }

    public String getEntryId3() {
        return entryId3;
    }

    public void setEntryId3(String entryId3) {
        this.entryId3 = entryId3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getMonth2() {
        return month2;
    }

    public void setMonth2(String month2) {
        this.month2 = month2;
    }

    public String getMonth3() {
        return month3;
    }

    public void setMonth3(String month3) {
        this.month3 = month3;
    }

    public String getToolTip1() {
        return toolTip1;
    }

    public void setToolTip1(String toolTip1) {
        this.toolTip1 = toolTip1;
    }

    public String getToolTip2() {
        return toolTip2;
    }

    public void setToolTip2(String toolTip2) {
        this.toolTip2 = toolTip2;
    }

    public String getToolTip3() {
        return toolTip3;
    }

    public void setToolTip3(String toolTip3) {
        this.toolTip3 = toolTip3;
    }
}
