package com.pingpong;

import java.io.Serializable;

/**
 * User: jitse
 * Date: 9/18/13
 * Time: 6:25 PM
 */
public class Lunches implements Serializable {
    private Player p1;
    private Player p2;
    private int p1Lunches = 0;
    private int p2Lunches = 0;

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public int getP1Lunches() {
        return p1Lunches;
    }

    public void setP1Lunches(int p1Lunches) {
        this.p1Lunches = p1Lunches;
    }

    public int getP2Lunches() {
        return p2Lunches;
    }

    public void setP2Lunches(int p2Lunches) {
        this.p2Lunches = p2Lunches;
    }
}
