package com.finance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * User: jitse
 * Date: 6/18/13
 * Time: 4:40 PM
 */
public class EntryCommand implements Serializable {

    private Map<String, String> payees;
    private Payee payee;
    private String amount;
    private Date date;
    private String notes;
    private String id;
    private String selectedPayeeId;
    private String returnTo;

    public String getReturnTo() {
        return returnTo;
    }

    public void setReturnTo(String returnTo) {
        this.returnTo = returnTo;
    }

    public String getSelectedPayeeId() {
        return selectedPayeeId;
    }

    public void setSelectedPayeeId(String selectedPayeeId) {
        this.selectedPayeeId = selectedPayeeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getPayees() {
        return payees;
    }

    public void setPayees(Map<String, String> payees) {
        this.payees = payees;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
