package com.pingpong;

import java.io.Serializable;

/**
 * User: jitse
 * Date: 7/23/13
 * Time: 9:51 PM
 */
public class Player implements Serializable {
    private String id;
    private String name;

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
}
