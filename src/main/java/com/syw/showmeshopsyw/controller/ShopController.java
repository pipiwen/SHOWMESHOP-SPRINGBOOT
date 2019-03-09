package com.syw.showmeshopsyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shop")
public class ShopController {
    @RequestMapping("fullWide")
    public String fullWide(){
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
