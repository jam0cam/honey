package com.pingpong;

import java.io.Serializable;
import java.util.Date;

/**
 * User: jitse
 * Date: 9/18/13
 * Time: 6:30 PM
 */
public class Lunch implements Serializable {

    private Player player;
    private Date date;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
