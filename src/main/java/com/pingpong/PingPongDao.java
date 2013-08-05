package com.pingpong;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * User: jitse
 * Date: 7/23/13
 * Time: 10:00 PM
 */
@Controller
public class PingPongDao implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private SqlMapClient sqlMapClient;

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }

    public List<Game> getGames() {
        return (List<Game>) sqlMapClientTemplate.queryForList("pingPong.getAllGames");
    }

    public List<Player> getPlayers() {
        return (List<Player>) sqlMapClientTemplate.queryForList("pingPong.getAllPlayers");
    }

    public void insertGame(Game game) {
        sqlMapClientTemplate.insert("pingPong.insertGame", game);
    }
}
