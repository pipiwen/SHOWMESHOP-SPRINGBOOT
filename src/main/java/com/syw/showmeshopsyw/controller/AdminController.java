package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.Admin;
import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.service.AdminService;
import com.syw.showmeshopsyw.util.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("adminPage")
    public String adminCount(){
        return "admin/login";
    }

    @PostMapping("login")
    public String login(Admin admin, Map<String, Object> map){
        if(!StringUtils.isEmpty(adminService.login(admin))){
            AdminUtil.setCurrentUser(admin);
            return "admin/dashboard";
        }else {
            map.put("msg","用户名密码错误");
            return "admin/login";
        }
    }
    @GetMapping("userList")
    public String userList(Model model){
        List<User>userList=adminService.findAllUser();
        model.addAttribute("users",userList);
        return "admin/userList";
    }
    @GetMapping("userForm")
    public String userForm(){
        return "admin/userForm";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){//@PathVariable restful路径变量
        User user = adminService.get(id);
        model.addAttribute("u",user);
        return "admin/userForm";
    }

    @PostMapping("addEdit")
    public String addUser(User user){
        adminService.addUser(user);
        return "redirect:/admin/userList";
    }
    @PutMapping("addEdit")
    public String editUser(User user){
        adminService.editUser(user);
        return "redirect:/admin/userList";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        adminService.deleteUser(id);
        return "redirect:/admin/userList";
    }
    @GetMapping("clothesList")
    public String clothesList(Model model){
        model.addAttribute("clothesList",adminService.findAllClothes());
        return "admin/clothesList";
    }
}
