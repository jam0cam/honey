package com.finance.model;

import java.io.Serializable;

/**
 * User: jitse
 * Date: 9/22/13
 * Time: 2:47 PM
 */
public class MonthTotal implements Serializable {
    private String month;
    private double total;
    private String formattedTotal;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormattedTotal() {
        return formattedTotal;
    }

    public void setFormattedTotal(String formattedTotal) {
        this.formattedTotal = formattedTotal;
    }
}
