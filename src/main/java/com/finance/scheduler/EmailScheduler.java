package com.finance.scheduler;

import com.common.Dao;
import com.finance.dao.NotifyDao;
import com.finance.dao.PayeeDao;
import com.finance.model.NotifyLog;
import com.finance.model.Payee;
import com.postageapp.MailSender;
import com.postageapp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * User: jitse
 * Date: 7/2/13
 * Time: 10:55 PM
 */
@Controller
@RequestMapping("/finance/mailer")
public class EmailScheduler {

    @Autowired
    private NotifyDao notifyDao;

    @Autowired
    private PayeeDao payeeDao;

    @Autowired
    private Dao dao;

    @Autowired
    private MailSender mailSender;

    private String messageBody;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String initiateRun() {
        perform();
        return "done";
    }

    @Scheduled(fixedDelay = 3600000)
    public void perform() {
        Date today = new Date();

        if (today.getHours() < 15) {
            return;
        }

        //get all the payees that have notification turned on
        List<Payee> payees = payeeDao.getAllPayeesNotifyOn();

        //for each of those payees, get all its notify logs
        for (Payee payee : payees) {

            //if today is the day to notify, then check to see if the logs indicate the notification has been sent
            if (payee.getNotifyDay().equals(Integer.toString(today.getDate()))) {
                NotifyLog log = notifyDao.getRecentNotification(payee.getId());
                if (log == null || (log.getDate().getMonth() != today.getMonth())){
                    //the logs show that no notification has been sent for this month
                    Response response = mailSender.sendMail(dao.getById(payee.getUserId()).getEmail(), payee.getName() + " Reminder", messageBody);
                    if (response != null) {
                        NotifyLog newLog = new NotifyLog();
                        newLog.setMessageUrl(response.getData().getMessage().get("url"));
                        newLog.setPayeeId(payee.getId());
                        notifyDao.insertLog(newLog);
                    }
                }
            }


        }
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
