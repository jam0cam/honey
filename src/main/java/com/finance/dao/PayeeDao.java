package com.finance.dao;

import com.finance.model.Payee;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: jitse
 * Date: 6/20/13
 * Time: 6:20 PM
 */
@Component
public class PayeeDao implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private SqlMapClient sqlMapClient;

    public Payee getPayeeByAccount(String account) {
        return (Payee) sqlMapClientTemplate.queryForObject("payee.getPayeeByAccount", account);
    }

    public Payee getPayeeById(String id) {
        return (Payee) sqlMapClientTemplate.queryForObject("payee.getPayeeById", id);
    }

    public Payee getPayeeByName(String name, String userId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("userId", userId);

        return (Payee) sqlMapClientTemplate.queryForObject("payee.getPayeeByName", params);
    }

    public List<Payee> getAllPayees(String userId) {
        return (List<Payee>) sqlMapClientTemplate.queryForList("payee.getAllPayees", userId);
    }

    public List<Payee> getAllPayeesNotifyOn() {
        return (List<Payee>) sqlMapClientTemplate.queryForList("payee.getAllPayeesNotifyOn");
    }

    public String addPayee(Payee command) {
        sqlMapClientTemplate.insert("payee.insertPayee", command);
        return command.getId();
    }

    public void deletePayee(String id) {
        sqlMapClientTemplate.delete("payee.deletePayee", id);
    }

    public void update(Payee payee) {
        sqlMapClientTemplate.update("payee.update", payee);
    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }

}
