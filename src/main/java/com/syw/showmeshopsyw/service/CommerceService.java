package com.syw.showmeshopsyw.service;

import com.syw.showmeshopsyw.entity.*;
import com.syw.showmeshopsyw.mapper.CommerceMapper;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service
public class CommerceService {
    @Autowired
    private CommerceMapper commerceMapper;
    public void addCart(Map<String,Object> jsonData){
        commerceMapper.addCart(jsonData);
    }
    public List<Clothes> showCart(Integer userId){
        return commerceMapper.showCart(userId);
    }
    public void addCompare(Integer clothesId,Integer userId){
        commerceMapper.addCompare(clothesId,userId);
    }
    public List<Clothes> showCompare(Integer userId){
        return commerceMapper.showCompare(userId);
    }
    public void delCart(Integer cartId){
        commerceMapper.delCart(cartId);
    }
    public List<Province> findAllProvince(){
       return commerceMapper.findAllProvince();
    }
    public List<City>findCityByProvince(String pno){
        return commerceMapper.findCityByProvince(pno);
    }
    public void modifyAmount(Map<String,Object> jsonData){
        commerceMapper.modifyAmount(jsonData);
    }
    public List<Clothes> showOrder(Integer userId){
       return commerceMapper.showOrder(userId);
    }

    @Transactional
    public void toOrder(Map<String,Object>jsonData){
        Integer userId=(Integer) jsonData.get("userId");
        List<Cart>cartList= commerceMapper.findCart(userId);
        for(int i=0;i<cartList.size();i++){
            commerceMapper.toOrder(cartList.get(i));
        }
        commerceMapper.delCartByUserId(userId);
        commerceMapper.addUserInfo(jsonData);
    }
    public List<Clothes> completeOrder(Integer userId){
        return commerceMapper.completeOrder(userId);
    }

    public UserInfo userInfo(Integer userId){
       return commerceMapper.userInfo(userId);
    }
}
