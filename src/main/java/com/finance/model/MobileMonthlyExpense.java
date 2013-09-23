package com.finance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 9/22/13
 * Time: 2:46 PM
 */
public class MobileMonthlyExpense implements Serializable {
    private List<MonthTotal> monthlyExpense = new ArrayList<MonthTotal>();
    private double grandTotal;
    private String formattedGrandTotal;

    public List<MonthTotal> getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(List<MonthTotal> monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getFormattedGrandTotal() {
        return formattedGrandTotal;
    }

    public void setFormattedGrandTotal(String formattedGrandTotal) {
        this.formattedGrandTotal = formattedGrandTotal;
    }
}
