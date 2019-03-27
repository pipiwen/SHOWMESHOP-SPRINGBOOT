package com.syw.showmeshopsyw.controller;
import com.syw.showmeshopsyw.entity.City;
import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.service.CommerceService;
import com.syw.showmeshopsyw.util.QRCodeUtil;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

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
    public String addCart(@RequestBody Map<String,Object> jsonData){
        Integer userId= UserUtil.getCurrentUser().getId();
        jsonData.put("userId",userId);
        Integer clothesId= (Integer) jsonData.get("id");
        if(UserUtil.getCurrentUser().getUsername()==null){
            return "请先登录";
        }else if (clothesId != null) {
            commerceService.addCart(jsonData);
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
    @ResponseBody
    public String addCompare(@RequestBody Map<String,Object>jsonData){
        Integer clothesId=(Integer)jsonData.get("id");
        if(UserUtil.getCurrentUser().getUsername()==null){
            return "请先登录";
        }else if(clothesId!=null){
            commerceService.addCompare(clothesId,UserUtil.getCurrentUser().getId());
        }
        return "添加成功";
    }
    @RequestMapping("delCompare")
    @ResponseBody
    public String delCompare(@RequestBody Integer id){
        if(id !=null){
            commerceService.delCompare(id);
            return "删除成功！";
        }
        return "删除失败！";
    }
    @RequestMapping("compare")
    public String compare(Model model){
        List<Clothes> list=commerceService.showCompare(UserUtil.getCurrentUser().getId());
        model.addAttribute("clothesCompare",list);
        return "compare";
    }

    @RequestMapping("operateOrder")
    @ResponseBody
    public String operateOrder(@RequestBody Map<String,Object> jsonData){
        Integer userId=UserUtil.getCurrentUser().getId();
        jsonData.put("userId",userId);
        if(userId!=null) {
            commerceService.toOrder(jsonData);
        }
        return "success";
    }

    @RequestMapping("tracking")
    public String tracking(Model model){
        Integer userId=UserUtil.getCurrentUser().getId();
        model.addAttribute("orderList",commerceService.completeOrder(UserUtil.getCurrentUser().getId()));
        model.addAttribute("userInfo",commerceService.userInfo(userId));
        return "tracking-order";
    }
    @RequestMapping("payFor")
    public String payFor(String price,Model model){
        model.addAttribute("price",price);
        QRCodeUtil.zxingCodeCreate(price,"D:/uploads/",
                200,"D:/uploads/zhi.jpg");
        return "pay-for";
    }

    @RequestMapping("checkOut")
    public String checkOut(Model model){
        model.addAttribute("province",commerceService.findAllProvince());
        if(UserUtil.getCurrentUser().getUsername()!=null){
           model.addAttribute("orderList",commerceService.showOrder(UserUtil.getCurrentUser().getId()));
        }
        return "checkout";
    }

    @RequestMapping("province")
    @ResponseBody
    public String findAllProvince(Model model){
        model.addAttribute("province",commerceService.findAllProvince());
        return "success";
    }
    @RequestMapping("city")
    @ResponseBody
    public List<City> findCityByProvince(@RequestBody String pno){
        List<City> cityList=commerceService.findCityByProvince(pno);
        return cityList;
    }
    @RequestMapping("amount")
    @ResponseBody
    public String modifyAmount(@RequestBody Map<String,Object> jsonData){
        commerceService.modifyAmount(jsonData);
        return "success";
    }
    @RequestMapping(value = "getQRImage")
    public void getImage(String price, HttpServletResponse response){
        String fileName=price+".jpg";
        String url="D:\\uploads\\"+fileName;
        try(FileInputStream in = new FileInputStream(Paths.get(url).toFile());
            OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int hasRead = 0;
            while ((hasRead = in.read(buffer))>0) {
                os.write(buffer, 0, hasRead);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
