package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clothes")
public class ClothesController {
    @RequestMapping("index")
    public String showIndex(){
        if(UserUtil.getCurrentUser()==null) {
            UserUtil.setCurrentUser(new User());
        }
        return "index";
    }
}
