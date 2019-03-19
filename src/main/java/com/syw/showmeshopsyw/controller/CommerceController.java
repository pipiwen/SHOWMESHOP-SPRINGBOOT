package com.syw.showmeshopsyw.controller;
import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.service.CommerceService;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public String addCart(@RequestBody Integer clothesId){
        if(UserUtil.getCurrentUser().getUsername()==null){
            return "请先登录";
        }else if (clothesId != null) {
            commerceService.addCart(clothesId, UserUtil.getCurrentUser().getId());
        }
        return "添加成功";
    }
    @RequestMapping("delCart")
    @ResponseBody
    public String delCart(@RequestBody Integer cartId){
        if(cartId !=null){
            commerceService.delCart(cartId);
            return "删除成功！";
        }
        return "删除失败！";
    }
    @RequestMapping("wishList")
    public String wishList(){
        return "wishlist";
    }

    @RequestMapping("addCompare")
    public String addCompare(Integer clothesId){
        if(UserUtil.getCurrentUser().getUsername()==null){
            return "my-account";
        }else if(clothesId!=null){
            commerceService.addCompare(clothesId,UserUtil.getCurrentUser().getId());
        }
        return "compare";
    }
    @RequestMapping("compare")
    public String compare(Model model){
        List<Clothes> list=commerceService.showCompare(UserUtil.getCurrentUser().getId());
        model.addAttribute("clothesCompare",list);
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
