package com.finance.dao;

import com.common.ResponseResult;
import com.common.Util;
import com.finance.model.DeleteObject;
import com.finance.model.Payee;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: jitse
 * Date: 6/20/13
 * Time: 6:20 PM
 */
@Controller
@RequestMapping("/finance/service/payee")
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

    @RequestMapping(value= "/getAllPayees/userId/{userId}", method= RequestMethod.GET)
    public @ResponseBody List<Payee> getAllPayees(@PathVariable("userId") String userId) {
        List<Payee> rval = (List<Payee>) sqlMapClientTemplate.queryForList("payee.getAllPayees", userId);

        for (Payee p : rval) {
            Util.assureHtpp(p);
        }
        return rval;
    }

    public List<Payee> getAllPayeesNotifyOn() {
        return (List<Payee>) sqlMapClientTemplate.queryForList("payee.getAllPayeesNotifyOn");
    }

    @RequestMapping(value= "/save", method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult payeeSave(@RequestBody Payee command) {
        if (!StringUtils.hasText(command.getId())) {
            addPayee(command);
        } else {
            update(command);
        }
        return new ResponseResult(command.getId());
    }

    public String addPayee(Payee command) {
        sqlMapClientTemplate.insert("payee.insertPayee", command);
        return command.getId();
    }

    @RequestMapping(value= "/delete", method= RequestMethod.POST)
    public @ResponseBody ResponseResult deletePayee(@RequestBody DeleteObject object) {
        sqlMapClientTemplate.delete("payee.deletePayee", object.getId());
        return new ResponseResult(object.getId());
    }

    public void update(Payee payee) {
        sqlMapClientTemplate.update("payee.update", payee);
    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }

}
