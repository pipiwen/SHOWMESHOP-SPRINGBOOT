package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.service.ShopService;
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

    @RequestMapping("fullWide")
    public String fullWide(int pageNum,Model model){
        model.addAttribute("clothesList",shopService.findByPage(pageNum,8));
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
