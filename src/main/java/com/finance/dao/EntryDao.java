package com.finance.dao;

import com.finance.model.EntryCommand;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: jitse
 * Date: 6/21/13
 * Time: 10:36 PM
 */
@Component
public class EntryDao  implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private SqlMapClient sqlMapClient;

    public String addEntry(EntryCommand command) {
        sqlMapClientTemplate.insert("entry.insertEntry", command);
        return command.getId();
    }

    public String updateEntry(EntryCommand command) {
        sqlMapClientTemplate.update("entry.updateEntry", command);
        return command.getId();
    }

    public List<EntryCommand> getEntriesByUserIdSortByDate(String userId) {
        return  (List<EntryCommand>)sqlMapClientTemplate.queryForList("entry.getEntriesByUserIdSortByDate", userId);
    }

    public List<EntryCommand> getEntriesByUserId(String userId) {
        return  (List<EntryCommand>)sqlMapClientTemplate.queryForList("entry.getEntriesByUserId", userId);
    }

    public void deleteEntry(String entryId) {
        sqlMapClientTemplate.delete("entry.deleteEntry", entryId);
    }

    public EntryCommand getEntryById(String entryId) {
        return  (EntryCommand)sqlMapClientTemplate.queryForObject("entry.getEntryById", entryId);

    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }
}
