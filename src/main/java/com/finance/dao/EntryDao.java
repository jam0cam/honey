package com.finance.dao;

import com.common.ResponseResult;
import com.finance.model.DeleteObject;
import com.finance.model.EntryCommand;
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
 * Date: 6/21/13
 * Time: 10:36 PM
 */
@Controller
@RequestMapping("/finance/service/entry")
public class EntryDao  implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private SqlMapClient sqlMapClient;

    @RequestMapping(value= "/save", method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult saveEntry(@RequestBody EntryCommand command) {
        if (StringUtils.hasText(command.getId())) {
            return new ResponseResult(updateEntry(command));
        } else {
            return new ResponseResult(addEntry(command));
        }
    }

    @RequestMapping(value= "/delete", method= RequestMethod.POST)
    public @ResponseBody ResponseResult deleteEntry(@RequestBody DeleteObject object) {
        sqlMapClientTemplate.delete("entry.deleteEntry", object.getId());
        return new ResponseResult(object.getId());
    }



    public String addEntry(EntryCommand command) {
        sqlMapClientTemplate.insert("entry.insertEntry", command);
        return command.getId();
    }

    public String updateEntry(EntryCommand command) {
        sqlMapClientTemplate.update("entry.updateEntry", command);
        return command.getId();
    }

    @RequestMapping(value= "/getEntriesLastNMonths/{month}/userId/{userId}", method= RequestMethod.GET)
    public @ResponseBody List<EntryCommand> getEntriesLastNMonths(@PathVariable("month") String month,
                                                    @PathVariable("userId") String userId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("month", month);
        return  (List<EntryCommand>)sqlMapClientTemplate.queryForList("entry.getEntriesLastNMonths", map);
    }


    public List<EntryCommand> getEntriesByUserIdSortByDate(String userId) {
        return  (List<EntryCommand>)sqlMapClientTemplate.queryForList("entry.getEntriesByUserIdSortByDate", userId);
    }

    @RequestMapping(value= "/getEntriesByUserId/{userId}", method= RequestMethod.GET)
    public @ResponseBody List<EntryCommand> getEntriesByUserId(@PathVariable("userId") String userId) {
        return  (List<EntryCommand>)sqlMapClientTemplate.queryForList("entry.getEntriesByUserId", userId);
    }

    public EntryCommand getEntryById(String entryId) {
        return  (EntryCommand)sqlMapClientTemplate.queryForObject("entry.getEntryById", entryId);

    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }
}
