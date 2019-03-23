package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.service.UserService;
import com.syw.showmeshopsyw.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("myCount")
    public String myCount(){
            return "my-account";
    }
    @RequestMapping("login")
    public String login(User user){
        try {
            userService.login(user);
        }catch (Exception e) {
            return "redirect:/user/myCount";
        }
        return "redirect:/shop/fullWide?pageNum=1";
    }
    @RequestMapping("register")
    public String register(User user){
        ResultBean resultBean=new ResultBean();
        userService.register(user);
        resultBean.setMsg("注册成功！");
        return "redirect:/clothes/index";
    }
}
