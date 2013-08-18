package com.common;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 */
@Controller
@RequestMapping("/service")
public class Dao implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private SqlMapClient sqlMapClient;

    public String insertRegistration(User command) {
        sqlMapClientTemplate.insert("sql.insertRegistration", command);
        return command.getId();
    }

    public void insertComments(About command) {
        sqlMapClientTemplate.insert("sql.insertComments", command);
    }

    public User getById(String id) {
        return (User) sqlMapClientTemplate.queryForObject("sql.getById", id);
    }

    public User getByEmail(String email) {
        return (User) sqlMapClientTemplate.queryForObject("sql.getByEmail", email);
    }


    @RequestMapping(value= "/login", method= RequestMethod.POST)
    public @ResponseBody
    User login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getEmail()) || !StringUtils.hasText(user.getPassword())) {
            return null;
        } else {
            return getByEmailAndPassword(user.getEmail(), user.getPassword());
        }
    }

    public User getByEmailAndPassword(String email, String password) {
        Map<String, String> params = new HashMap<String, String>();

        params.put("email", email);
        params.put("password", password);

        return (User) sqlMapClientTemplate.queryForObject("sql.getByEmailAndPassword", params);
    }

    public String updatePassword(User user) {
        sqlMapClientTemplate.update("sql.updatePassword", user);
        return user.getId();
    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }
}
