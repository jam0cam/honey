package com.finance.model;

import java.io.Serializable;
import java.util.Date;

/**
 * User: jitse
 * Date: 7/13/13
 * Time: 2:01 PM
 */
public class NotifyLog implements Serializable {

    private String id;
    private String payeeId;
    private Date date;
    private String messageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }
}
