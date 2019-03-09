package com.syw.showmeshopsyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pages")
public class PagesController {
    @RequestMapping("coming")
    public String coming(){
        return "coming-soon";
    }
    @RequestMapping("faq")
    public String faq(){
        return "faq";
    }
}
