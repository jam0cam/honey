package com.pingpong;

import com.common.Util;
import com.highchart.AxisData;
import com.highchart.GraphData;
import com.highchart.PieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 8/2/13
 * Time: 7:17 PM
 */
@Controller
@RequestMapping("/tt")
public class StatsController {


    @Autowired
    private SimpleDateFormat dateFormatter;

    @Autowired
    private PingPongDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView stats () {

        Series command = getSeries();

        return new ModelAndView("pingpong/stats", "command", command);
    }

    private PieData getPieDataSeries(Series command, boolean isSeries) {
        PieData rval = new PieData();

        List<List<Object>> data = new ArrayList<List<Object>>();

        List<Object> series1 = new ArrayList<Object>();
        series1.add(command.getPlayerOne());
        if (isSeries) {
            series1.add(command.getPlayer1SeriesWin());
        } else {
            series1.add(command.getPlayer1TotalWin());
        }


        List<Object> series2 = new ArrayList<Object>();
        series2.add(command.getPlayerTwo());
        if (isSeries) {
            series2.add(command.getPlayer2SeriesWin());
        } else {
            series2.add(command.getPlayer2TotalWin());
        }
        data.add(series1);
        data.add(series2);

        rval.setData(data);
        if (isSeries) {
            rval.setName("Series Won");
        } else {
            rval.setName("Games Won");
        }

        rval.setTitle("");

        return rval;
    }

    @RequestMapping(value="/monthly/game", method = RequestMethod.GET)
    public @ResponseBody
    GraphData getDataGame () {
        Series command = getSeries();
        List<String> monthList = Util.getMonthList(command.getMinMonth(), command.getMaxMonth());
        List<List<Integer>> monthlyData = getMonthlySum(command, false);

        if (monthlyData.get(0).size() != monthList.size()) {
            //validation error.
            throw new RuntimeException("There is an error in calculating the monthly data");
        }

        GraphData data = new GraphData();

        com.highchart.Series series = new com.highchart.Series();
        series.setMyData(monthlyData.get(0));
        series.setName(command.getPlayerOne());

        com.highchart.Series series2 = new com.highchart.Series();
        series2.setMyData(monthlyData.get(1));
        series2.setName(command.getPlayerTwo());

        data.getSeries().add(series);
        data.getSeries().add(series2);

        AxisData xAxis = new AxisData();
        xAxis.setData(monthList);

        data.setxAxis(xAxis);
        data.setyTitle("Total Games Won");
        data.setPieData(getPieDataSeries(command, false));
        return data;
    }

    @RequestMapping(value="/monthly/series", method = RequestMethod.GET)
    public @ResponseBody
    GraphData getDataSeries () {
        Series command = getSeries();
        List<String> monthList = Util.getMonthList(command.getMinMonth(), command.getMaxMonth());
        List<List<Integer>> monthlyData = getMonthlySum(command, true);

        if (monthlyData.get(0).size() != monthList.size()) {
            //validation error.
            throw new RuntimeException("There is an error in calculating the monthly data");
        }
        if (monthlyData.get(0).size() != monthList.size()) {
            //validation error.
            throw new RuntimeException("There is an error in calculating the monthly data");
        }

        GraphData data = new GraphData();

        com.highchart.Series series = new com.highchart.Series();
        series.setMyData(monthlyData.get(0));
        series.setName(command.getPlayerOne());

        com.highchart.Series series2 = new com.highchart.Series();
        series2.setMyData(monthlyData.get(1));
        series2.setName(command.getPlayerTwo());

        data.getSeries().add(series);
        data.getSeries().add(series2);

        AxisData xAxis = new AxisData();
        xAxis.setData(monthList);

        data.setxAxis(xAxis);
        data.setyTitle("Total Series Won");
        data.setPieData(getPieDataSeries(command, true));
        return data;
    }

    /**
     * Player 1 is returned at index 0, player 2 at index 1
     * @param command
     * @param isSeries
     * @return
     */
    private List<List<Integer>> getMonthlySum(Series command, boolean isSeries) {
        List<Integer> p1MonthlyTotal = new ArrayList<Integer>();
        List<Integer> p2MonthlyTotal = new ArrayList<Integer>();

        int curMonth = command.getMinMonth();
        int p1MonthSum = 0;
        int p2MonthSum = 0;

        //the last element has the smallest date
        for (int i= command.getGames().size() -1; i>=0; i--) {
            Game game = command.getGames().get(i);
            if (game.getDate().getMonth() == curMonth) {
                if (isSeries) { //for series, we calculate the monthly sum in a different way
                    if (game.getWinner().equals(game.getPlayer1().getName())) {
                        p1MonthSum++;
                    } else {
                        p2MonthSum++;
                    }
                } else {
                    p1MonthSum += game.getPlayer1Score();
                    p2MonthSum += game.getPlayer2Score();
                }
            } else {
                //save the data from the previous month
                p1MonthlyTotal.add(p1MonthSum);
                p2MonthlyTotal.add(p2MonthSum);

                //if there are gaps in months between games, we want to fill that with 0s
                curMonth++;
                while (curMonth != game.getDate().getMonth()) {
                    p1MonthlyTotal.add(0);
                    p2MonthlyTotal.add(0);
                    curMonth++;

                    if (curMonth > 15) {
                        throw new RuntimeException("Something went wrong, terminating to save itself");
                    }
                }

                //initializing a new month
                if (isSeries) {
                    if (game.getWinner().equals(game.getPlayer1().getName())) {
                        p1MonthSum=1;
                        p2MonthSum=0;
                    } else {
                        p2MonthSum=1;
                        p1MonthSum=0;
                    }
                } else {
                    p1MonthSum = game.getPlayer1Score();
                    p2MonthSum = game.getPlayer2Score();
                }
            }
        }

        //add the last batch onto the list
        p1MonthlyTotal.add(p1MonthSum);
        p2MonthlyTotal.add(p2MonthSum);

        List<List<Integer>> rval = new ArrayList<List<Integer>>();
        rval.add(p1MonthlyTotal);
        rval.add(p2MonthlyTotal);

        return rval;
    }

    private Series getSeries() {
        Series series = new Series();
        List<Game> games = dao.getGames();
        if (!games.isEmpty()) {

            String player1 = games.get(games.size()-1).getPlayer1().getName();
            String player2 = games.get(games.size()-1).getPlayer2().getName();

            //group the games into series
            for (Game game : games) {
                //the intent is to get the same person as "player 1" for all games
                if (!game.getPlayer1().getName().equals(player1)) {
                    swapPlayers(game);
                }

                if (game.getPlayer1Score() > game.getPlayer2Score()) {
                    game.setWinner(player1);
                    series.setPlayer1SeriesWin(series.getPlayer1SeriesWin()+1);
                } else if (game.getPlayer1Score() < game.getPlayer2Score()) {
                    game.setWinner(player2);
                    series.setPlayer2SeriesWin(series.getPlayer2SeriesWin() + 1);
                } else {
                    game.setWinner("TIE");
                }

                series.setPlayer1TotalWin((series.getPlayer1TotalWin() + game.getPlayer1Score()));
                series.setPlayer2TotalWin((series.getPlayer2TotalWin() + game.getPlayer2Score()));
                int month = game.getDate().getMonth();
                if (series.getMinMonth() > month) {
                    series.setMinMonth(month);
                }
                if (series.getMaxMonth() < month) {
                    series.setMaxMonth(month);
                }

                game.setDateString(dateFormatter.format(game.getDate()));
            }

            series.setGames(games);
            series.setPlayerOne(player1);
            series.setPlayerTwo(player2);
        }
        return series;
    }

    public void swapPlayers(Game game) {
        Player player = game.getPlayer1();
        game.setPlayer1(game.getPlayer2());
        game.setPlayer2(player);
    }
}
