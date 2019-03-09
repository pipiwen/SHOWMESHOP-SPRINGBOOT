package com.syw.showmeshopsyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clothes")
public class ClothesController {
    @RequestMapping("index")
    public String showIndex(){
        return "index";
    }
}
