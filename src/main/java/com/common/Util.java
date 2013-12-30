package com.common;

import com.finance.model.EntryCommand;
import com.finance.model.Payee;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 6/21/13
 * Time: 10:50 PM
 */
public class Util {

    public static String getMonthName(int i) {
        if (i == 1 || i == 13) {
            return "Jan";
        } else if (i == 2) {
            return "Feb";
        } else if (i == 3) {
            return "Mar";
        } else if (i == 4) {
            return "Apr";
        } else if (i == 5) {
            return "May";
        } else if (i == 6) {
            return "Jun";
        } else if (i == 7) {
            return "Jul";
        } else if (i == 8) {
            return "Aug";
        } else if (i == 9) {
            return "Sep";
        } else if (i == 10) {
            return "Oct";
        } else if (i == 11 || i == -1) {
            return "Nov";
        } else if (i == 12 || i == 0) {
            return "Dec";
        }

        return "???";
    }

    /**
     * 0 = Jan, 11 = Dec
     * @param begin
     * @param end
     * @return
     */
    public static List<String> getMonthList(int begin, int end) {
        List<String> rval = new ArrayList<String>();

        for (int i=begin; i<=end; i++) {
            rval.add(getMonthName(i+1));
        }

        return rval;
    }

    public static void trimRegister(User user) {
        user.setPassword(user.getPassword().trim());
        user.setEmail(user.getEmail().trim());
        user.setName(user.getName().trim());
    }

    public static void trimPayee(Payee payee) {
        payee.setName(payee.getName().trim());
        payee.setAccountNumber(payee.getAccountNumber().trim());
        payee.setPhone(payee.getPhone().trim());
        payee.setUrl(payee.getUrl().trim());
    }

    public static void trimEntry(EntryCommand entry) {
        entry.setAmount(entry.getAmount().trim().replace("$", ""));
        entry.setNotes(entry.getNotes().trim());
    }


    public static List<Integer> getMonthlyTotal(List<EntryCommand> entries) {
        List<Integer> rval = new ArrayList<Integer>();

        List<Double> monthlyTotal = getMonthlyTotalAccurate(entries);

        for (Double d : monthlyTotal) {
            rval.add(d.intValue());
        }
        return rval;
    }

    public static List<Double> getMonthlyTotalAccurate(List<EntryCommand> entries) {
        List<Double> rval = new ArrayList<Double>();

        //the data is assumed to be sorted by date.
        int curMonth = entries.get(0).getDate().getMonth();
        double runningSum = 0;
        for (EntryCommand entry : entries) {
            if (entry.getDate().getMonth() == curMonth) {
                runningSum += Double.parseDouble(entry.getAmount());
            } else {
                //save the data from the previous month
                rval.add(runningSum);

                //if there are gaps in months between games, we want to fill that with 0s
                curMonth++;
                while (curMonth != entry.getDate().getMonth()) {
                    rval.add(0.00);
                    curMonth++;

                    if (curMonth > 15) {
                        throw new RuntimeException("Something went wrong, terminating to save itself");
                    }
                }

                //initializing a new month
                runningSum = Double.parseDouble(entry.getAmount());
            }
        }

        //add the last batch onto the list
        rval.add(runningSum);

        return rval;
    }

    public static List<String> getMonthList(List<EntryCommand> entries) {
        int minMonth = 15;
        int maxMonth = -1;

        for (EntryCommand entry : entries) {
            if (entry.getDate().getMonth() < minMonth) {
                minMonth = entry.getDate().getMonth();
            }
            if (entry.getDate().getMonth() > maxMonth) {
                maxMonth = entry.getDate().getMonth();
            }
        }

        return Util.getMonthList(minMonth, maxMonth);
    }

    /**
     * Makes sure that the url (if any) isn't just www. It'll have http://www....
     * @param payee
     */
    public static void assureHtpp(Payee payee) {
        if (StringUtils.hasText(payee.getUrl()) && payee.getUrl().startsWith("www.")){
                payee.setUrl("http://" + payee.getUrl());
        }
    }
}
