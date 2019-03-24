package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.util.QQMailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(("blog"))
public class BlogController {

    @RequestMapping("contact")
    public String contact(){
        return "contact";
    }
    @RequestMapping("sendMessage")
    @ResponseBody
    public String sendMail(@RequestBody Map<String,Object>jsonData)throws Exception{
        String name=(String) jsonData.get("name");
        String subject=(String) jsonData.get("subject");
        String context=(String) jsonData.get("context");
        QQMailUtil.QQmail(subject,name,context);
        return "发送成功";
    }
}
