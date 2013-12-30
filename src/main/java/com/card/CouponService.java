package com.card;

import com.aws.S3Service;
import com.common.ResponseResult;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * User: jitse
 * Date: 9/28/13
 * Time: 6:10 PM
 */
@Controller
@RequestMapping("/coupon/service")
public class CouponService implements InitializingBean {
    private SqlMapClientTemplate sqlMapClientTemplate;

    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private S3Service s3Service;

    @Autowired
    private SqlMapClient sqlMapClient;


    @RequestMapping(value= "/get/userId/{userId}", method= RequestMethod.GET)
    @ResponseBody
    public List<Coupon> getCouponByUserId(@PathVariable("userId") String userId){
        userId = "1";
        List<Coupon> rval = (List<Coupon>)sqlMapClientTemplate.queryForList("card.getCouponByUserId", userId);

        return rval;
    }

    @RequestMapping(value = "/addAttachment", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult add (@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws Exception {
        //s3Service.uploadFile(multipartFile);

        Attachment attachment = new Attachment();
        attachment.setParentId(request.getParameter("parentId"));
        attachment.setType(AttachmentType.fromValue(request.getParameter("attachmentType")));

        //TODO: JIA: set this image URL
        attachment.setImageUrl("");
        insertAttachment(attachment);
        return new ResponseResult(attachment.getId());
    }

    @RequestMapping(value = "/addCoupon", method = RequestMethod.POST)
    @ResponseBody
    private String insertCoupon(@RequestBody Coupon coupon) {
        sqlMapClientTemplate.insert("card.insertCoupon", coupon);
        return coupon.getId();
    }

    private String insertAttachment(Attachment attachment) {
        sqlMapClientTemplate.insert("card.insertAttachment", attachment);
        return attachment.getId();
    }

    public void afterPropertiesSet() throws Exception {
        this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }

}
