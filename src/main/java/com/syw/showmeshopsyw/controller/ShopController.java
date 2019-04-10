package com.syw.showmeshopsyw.controller;

import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.service.CommerceService;
import com.syw.showmeshopsyw.service.ShopService;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
        return "shop-full-wide";
    }
    @RequestMapping("byCondition")
    public String byCondition(int pageNum, String condition,Model model){
        model.addAttribute("clothesList",shopService.findByPageByCondition(pageNum,8,condition));
        return "shop-full-wide";
    }

    @RequestMapping("byPrice")
    public String byPrice(int pageNum, String condition,Model model){
        model.addAttribute("clothesList",shopService.findByByPrice(pageNum,8,condition));
        return "shop-full-wide";
    }
    @RequestMapping("byColor")
    public String byColor(int pageNum, String color,Model model){
        model.addAttribute("clothesList",shopService.findByColor(pageNum,8,color));
        return "shop-full-wide";
    }
    @RequestMapping("bySize")
    public String bySize(int pageNum, String size,Model model){
        model.addAttribute("clothesList",shopService.findBySize(pageNum,8,size));
        return "shop-full-wide";
    }
    @RequestMapping("bySex")
    public String bySex(int pageNum, Integer sex,Model model){
        model.addAttribute("clothesList",shopService.findBySex(pageNum,8,sex));
        return "shop-full-wide";
    }
    @RequestMapping("singleProduct")
    public String showSingle(Integer clothesId,Model model){
        model.addAttribute("clothes",shopService.singleProduct(clothesId));
        return "single-product";
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
