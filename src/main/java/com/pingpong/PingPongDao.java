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

    /**
     * Returns the sweeps data. A sweep is all the games in the database that is 5-0
     * @return
     */
    @RequestMapping(value= "/sweeps", method= RequestMethod.GET)
    public @ResponseBody Sweeps getSweeps() {
        List<Game> games = getGames();

        Sweeps sweep = new Sweeps();
        sweep.setPlayer1(games.get(games.size()-1).getPlayer1());
        sweep.setPlayer2(games.get(games.size() - 1).getPlayer2());

        String player1 = games.get(games.size()-1).getPlayer1().getName();

        for (Game game : games) {
            //the intent is to get the same person as "player 1" for all games
            if (!game.getPlayer1().getName().equals(player1)) {
                swapPlayers(game);
            }

            if (game.getPlayer1Score() == 5){
                sweep.setPlayer1Score(sweep.getPlayer1Score() + 1);
            } else if (game.getPlayer2Score() == 5) {
                sweep.setPlayer2Score(sweep.getPlayer2Score() + 1);
            }
        }

        return sweep;
    }

    @RequestMapping(value= "/lunches", method= RequestMethod.GET)
    public @ResponseBody
    Lunches getLunches() {
        List<Lunch> lunches = (List<Lunch>) sqlMapClientTemplate.queryForList("pingPong.getAllLunches");

        if (lunches == null || lunches.isEmpty()){return null;}

        //establishing who is player 1, the other person is player 2
        Player p1 = lunches.get(0).getPlayer();
        Player p2 = null;
        Lunches rval = new Lunches();
        rval.setP1(p1);

        for (Lunch l : lunches){
            //this will set player 2
            if (p2 == null && !l.getPlayer().getId().equals(p1.getId())){
                p2 = l.getPlayer();
            }

            if (l.getPlayer().getId().equals(p1.getId())){rval.setP1Lunches(rval.getP1Lunches()+1);}
            else {rval.setP2Lunches(rval.getP2Lunches()+1);}
        }

        rval.setP1(p1);
        rval.setP2(p2);

        return rval;
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
