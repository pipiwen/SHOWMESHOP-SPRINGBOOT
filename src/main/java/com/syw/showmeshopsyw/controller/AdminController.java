package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.Admin;
import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.service.AdminService;
import com.syw.showmeshopsyw.util.AdminUtil;
import com.syw.showmeshopsyw.util.QnUpload;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private QnUpload qnUpload;
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

    @PostMapping("clothesAddEdit")
    public String clothesAddUser(Clothes clothes,
                                 @RequestParam("file1") MultipartFile file1,
                                 @RequestParam("file2") MultipartFile file2
                                 ) throws IllegalStateException, IOException {
        String name1=file1.getOriginalFilename();
        String name2=file2.getOriginalFilename();
        String n1=name1.substring(0, name1.lastIndexOf("."));
        String n2=name1.substring(0, name2.lastIndexOf("."));
        clothes.setPicAddress1(n1);
        clothes.setPicAddress2(n2);
        adminService.addClothes(clothes);
        byte[] b1=file1.getBytes();
        byte[] b2=file2.getBytes();
        qnUpload.upload(b1,name1);
        qnUpload.upload(b2,name2);
       return "redirect:/admin/clothesList";
    }


    @PutMapping("clothesAddEdit")
    public String clothesEditUser(Clothes clothes){
        adminService.editClothes(clothes);
        return "redirect:/admin/clothesList";
    }
    @GetMapping("editClothes/{id}")
    public String editClothes(@PathVariable("id") Integer id,Model model){//@PathVariable restful路径变量
        Clothes clothes=adminService.getClothesByid(id);
        model.addAttribute("c",clothes);
        return "admin/clothesForm";
    }
    @GetMapping("cForm")
    public String cForm(){
        return "admin/clothesForm";
    }

    @GetMapping("orderList")
    public String orderList(Model model){
        model.addAttribute("orderList",adminService.findAllOrder());
        return "admin/orderList";
    }

    @GetMapping("orderFrom/{id}/{del_flag}")
    public String orderFrom(@PathVariable("id")Integer userId,
                            @PathVariable("del_flag")Integer del_flag,Model model){
        model.addAttribute("clothesList",adminService.findClothesByUserId(userId,del_flag));
        return "admin/oForm";
    }
    @RequestMapping("deleteOrder")
    public String delOrder(Integer userId){
        adminService.delOrder(userId);
        return "redirect:/admin/orderList";
    }

}
