package com.finance.model;

import java.io.Serializable;

/**
 * User: jitse
 * Date: 8/22/13
 * Time: 10:21 AM
 */
public class DeleteObject implements Serializable {
    private String id;

    public DeleteObject(String id) {
        this.id = id;
    }

    public DeleteObject(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
