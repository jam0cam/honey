package com.finance.model;

/**
 * User: jitse
 * Date: 6/18/13
 * Time: 1:23 PM
 */
public class Payee {

    private String name;
    private String accountNumber;
    private String phone;
    private String id;
    private String userId;
    private boolean notifyOn;
    private String notifyDay = "1";
    private String notes;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isNotifyOn() {
        return notifyOn;
    }

    public void setNotifyOn(boolean notifyOn) {
        this.notifyOn = notifyOn;
    }

    public String getNotifyDay() {
        return notifyDay;
    }

    public void setNotifyDay(String notifyDay) {
        this.notifyDay = notifyDay;
    }
}
