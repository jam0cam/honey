package com.pingpong;

import com.common.ResponseResult;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * User: jitse
 * Date: 7/23/13
 * Time: 10:00 PM
 */
@Controller
@RequestMapping("/pingpong/service/")
public class PingPongDao implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    protected SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Autowired
    private SqlMapClient sqlMapClient;

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }


    @RequestMapping(value= "/games", method= RequestMethod.GET)
    public @ResponseBody List<Game> getGames() {
        List<Game> games = (List<Game>) sqlMapClientTemplate.queryForList("pingPong.getAllGames");
        return games;
    }

    @RequestMapping(value= "/series", method= RequestMethod.GET)
    public @ResponseBody Series getSeries() {
        List<Game> games = getGames();

        Series series = new Series();

        //group the games into series
        String player1 = games.get(games.size()-1).getPlayer1().getName();
        String player2 = games.get(games.size()-1).getPlayer2().getName();

        series.setPlayerOne(player1);
        series.setPlayerTwo(player2);

        for (Game game : games) {
            //the intent is to get the same person as "player 1" for all games
            if (!game.getPlayer1().getName().equals(player1)) {
                swapPlayers(game);
            }

            if (game.getPlayer1Score() > game.getPlayer2Score()) {
                series.setPlayer1SeriesWin(series.getPlayer1SeriesWin()+1);
            } else  {
                series.setPlayer2SeriesWin(series.getPlayer2SeriesWin() + 1);
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
        }
        return series;
    }


    private void swapPlayers(Game game) {
        Player player = game.getPlayer1();
        game.setPlayer1(game.getPlayer2());
        game.setPlayer2(player);
    }

    @RequestMapping(value= "/recentGames", method= RequestMethod.GET)
    public @ResponseBody List<Game> getRecentGames() {
        List<Game> games = (List<Game>) sqlMapClientTemplate.queryForList("pingPong.getRecentGames");
        return games;
    }

    public List<Player> getPlayers() {
        return (List<Player>) sqlMapClientTemplate.queryForList("pingPong.getAllPlayers");
    }


    @RequestMapping(value= "/save", method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult insertGame(@RequestBody Game game) {
        sqlMapClientTemplate.insert("pingPong.insertGame", game);
        return new ResponseResult(game.getId());
    }
}
