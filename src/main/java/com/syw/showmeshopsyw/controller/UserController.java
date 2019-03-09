package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.mapper.UserMapper;
import com.syw.showmeshopsyw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.get(id);
    }
    @RequestMapping("test")
    public String test1(Model model){
        model.addAttribute("test","测试thymeleaf");
        return "test";
    }
}
