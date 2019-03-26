package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.service.UserService;
import com.syw.showmeshopsyw.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public String register(@RequestBody Map<String,Object>jsonData){
        String username=(String) jsonData.get("username");
        List<User> userList=userService.findAllUser();
        for(User u:userList){
            if (u.getUsername().equals(username)){
                return "用户名已存在";
            }
        }
        userService.register(jsonData);
        return "注册成功";
    }
}
