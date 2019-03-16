package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.service.CommerceService;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("commerce")
public class CommerceController {
    @Autowired
    private CommerceService commerceService;
    @RequestMapping("account")
    public String account(){
        return "my-account";
    }
    @RequestMapping("cart")
    public String cart(Model model){
        List<Clothes> list=commerceService.showCart(UserUtil.getCurrentUser().getId());
        model.addAttribute("clothes",list);
        return "cart";
    }

    @RequestMapping("addCart")
    public String addCart(Integer clothesId){
        if(UserUtil.getCurrentUser().getUsername()==null){
            return "my-account";
        }else if(clothesId!=null){
            commerceService.addCart(clothesId,UserUtil.getCurrentUser().getId());
        }
        return "cart";
    }
    @RequestMapping("wishList")
    public String wishList(){
        return "wishlist";
    }
    @RequestMapping("compare")
    public String compare(){
        return "compare";
    }
    @RequestMapping("tracking")
    public String tracking(){
        return "tracking-order";
    }
    @RequestMapping("checkOut")
    public String checkOut(){
        return "checkout";
    }
}
