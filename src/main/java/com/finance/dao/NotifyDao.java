package com.finance.dao;

import com.finance.model.NotifyLog;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: jitse
 * Date: 7/17/13
 * Time: 9:46 PM
 */
@Component
public class NotifyDao   implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private SqlMapClient sqlMapClient;

    public List<NotifyLog> getNotificationsByPayeeId(String id) {
        return  (List<NotifyLog>)sqlMapClientTemplate.queryForList("notify.getNotificationsByPayeeId", id);
    }

    public NotifyLog getRecentNotification(String payeeId) {
        return  (NotifyLog) sqlMapClientTemplate.queryForObject("notify.getRecentNotification", payeeId);
    }

    public String insertLog(NotifyLog command) {
        sqlMapClientTemplate.insert("notify.insertLog", command);
        return command.getId();
    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }
}