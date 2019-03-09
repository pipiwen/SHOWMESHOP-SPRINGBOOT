package com.syw.showmeshopsyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("commerce")
public class CommerceController {
    @RequestMapping("account")
    public String account(){
        return "my-account";
    }
    @RequestMapping("cart")
    public String cart(){
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
