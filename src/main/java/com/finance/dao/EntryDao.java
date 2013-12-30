package com.finance.dao;

import com.common.ResponseResult;
import com.common.Util;
import com.finance.model.DeleteObject;
import com.finance.model.EntryCommand;
import com.finance.model.MobileMonthlyExpense;
import com.finance.model.MonthTotal;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

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

    @RequestMapping(value="/mobile/monthlyExpense/userId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    MobileMonthlyExpense monthlyExpenseForMobile (@PathVariable("userId") String userId) {

        MobileMonthlyExpense rval = new MobileMonthlyExpense();

        List<EntryCommand> entries = getEntriesByUserIdSortByDate(userId);
        List<String> monthList = Util.getMonthList(entries);
        List<Double> valuesList = Util.getMonthlyTotalAccurate(entries);

        double grandTotal = 0;

        for (int i =0; i< monthList.size(); i++) {
            MonthTotal line = new MonthTotal();
            line.setMonth(monthList.get(i));
            line.setTotal(valuesList.get(i));
            line.setFormattedTotal(currencyFormatter.format(valuesList.get(i)));

            grandTotal += valuesList.get(i);
            rval.getMonthlyExpense().add(line);
        }

        rval.setGrandTotal(grandTotal);
        rval.setFormattedGrandTotal(currencyFormatter.format(grandTotal));
        return rval;
    }

    @RequestMapping(value="/mobile/payeeExpense/userId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    MobileMonthlyExpense payeeExpenseForMobile (@PathVariable("userId") String userId) {
        MobileMonthlyExpense rval = new MobileMonthlyExpense();

        List<EntryCommand> entries = getEntriesByUserId(userId);

        //the data is assumed to be sorted by payee.
        String payee = entries.get(0).getPayee().getName();
        double grandTotal = 0;
        double runningSum = 0;
        for (EntryCommand entry : entries) {
            if (entry.getPayee().getName().equals(payee)) {
                runningSum += Double.parseDouble(entry.getAmount());
            } else {
                //save the data from the previous payee;
                MonthTotal line = new MonthTotal();
                line.setMonth(payee);
                line.setTotal(runningSum);
                line.setFormattedTotal(currencyFormatter.format(runningSum));
                rval.getMonthlyExpense().add(line);

                //initializing a new payee
                grandTotal += runningSum;
                runningSum = Double.parseDouble(entry.getAmount());
                payee = entry.getPayee().getName();
            }
        }

        grandTotal += runningSum;
        //add the last batch onto the list
        MonthTotal line = new MonthTotal();
        line.setMonth(payee);
        line.setTotal(runningSum);
        line.setFormattedTotal(currencyFormatter.format(runningSum));
        rval.getMonthlyExpense().add(line);

        rval.setGrandTotal(grandTotal);
        rval.setFormattedGrandTotal(currencyFormatter.format(grandTotal));
        return rval;
    }


    @RequestMapping(value= "/getEntriesByUserId/{userId}", method= RequestMethod.GET)
    public @ResponseBody List<EntryCommand> getEntriesByUserId(@PathVariable("userId") String userId) {
        List<EntryCommand> rval = (List<EntryCommand>)sqlMapClientTemplate.queryForList("entry.getEntriesByUserId", userId);

        for (EntryCommand c : rval) {
            Util.assureHtpp(c.getPayee());
        }

        return rval;
    }

    public EntryCommand getEntryById(String entryId) {
        return  (EntryCommand)sqlMapClientTemplate.queryForObject("entry.getEntryById", entryId);

    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }
}
