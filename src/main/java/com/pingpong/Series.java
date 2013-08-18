package com.pingpong;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: jitse
 * Date: 7/25/13
 * Time: 5:30 PM
 */
public class Series implements Serializable {

    private int minMonth = 11;  //11 is december
    private int maxMonth = 0;       //0 is january
    private String playerOne;
    private String playerTwo;
    private List<Game> games;
    private Game newGame = new Game();
    private int player1TotalWin = 0;
    private int player1SeriesWin = 0;
    private int player2TotalWin = 0;
    private int player2SeriesWin = 0;
    private Date today;

    public int getMinMonth() {
        return minMonth;
    }

    public void setMinMonth(int minMonth) {
        this.minMonth = minMonth;
    }

    public int getMaxMonth() {
        return maxMonth;
    }

    public void setMaxMonth(int maxMonth) {
        this.maxMonth = maxMonth;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Game getNewGame() {
        return newGame;
    }

    public void setNewGame(Game newGame) {
        this.newGame = newGame;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public int getPlayer1TotalWin() {
        return player1TotalWin;
    }

    public void setPlayer1TotalWin(int player1TotalWin) {
        this.player1TotalWin = player1TotalWin;
    }

    public int getPlayer1SeriesWin() {
        return player1SeriesWin;
    }

    public void setPlayer1SeriesWin(int player1SeriesWin) {
        this.player1SeriesWin = player1SeriesWin;
    }

    public int getPlayer2TotalWin() {
        return player2TotalWin;
    }

    public void setPlayer2TotalWin(int player2TotalWin) {
        this.player2TotalWin = player2TotalWin;
    }

    public int getPlayer2SeriesWin() {
        return player2SeriesWin;
    }

    public void setPlayer2SeriesWin(int player2SeriesWin) {
        this.player2SeriesWin = player2SeriesWin;
    }
}
