package com.card;

import com.aws.S3Service;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * User: jitse
 * Date: 9/28/13
 * Time: 11:24 AM
 */
@Controller
@RequestMapping("/card/service")
public class CardService implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private SqlMapClient sqlMapClient;

    @RequestMapping(value= "/test", method= RequestMethod.GET)
    public @ResponseBody
    String test() {
        return "hello";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String upload (@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws Exception {

        //s3Service.uploadFile(multipartFile);
        return "true";
    }



    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }
}
