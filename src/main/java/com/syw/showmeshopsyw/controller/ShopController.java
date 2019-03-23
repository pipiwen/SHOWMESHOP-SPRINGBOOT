package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.service.CommerceService;
import com.syw.showmeshopsyw.service.ShopService;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private CommerceService commerceService;

    @RequestMapping("fullWide")
    public String fullWide(int pageNum,Model model){
        model.addAttribute("clothesList",shopService.findByPage(pageNum,8));
        List<Clothes> list=commerceService.showCart(UserUtil.getCurrentUser().getId());
        model.addAttribute("cl",list);
        return "shop-full-wide";
    }
    @RequestMapping("collection")
    public String collection(){
        return "shop-collection";
    }
    @RequestMapping("configurable")
    public String configurable(){
        return "single-product-configurable";
    }



}
