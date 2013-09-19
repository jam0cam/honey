package com.pingpong;

import java.io.Serializable;

/**
 * User: jitse
 * Date: 9/18/13
 * Time: 5:39 PM
 */
public class Sweeps  implements Serializable {
    private Player player1;
    private Player player2;
    private int player1Score = 0;
    private int player2Score = 0;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }
}
