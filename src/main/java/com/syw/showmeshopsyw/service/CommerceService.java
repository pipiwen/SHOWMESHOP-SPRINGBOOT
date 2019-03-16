package com.syw.showmeshopsyw.service;

import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.mapper.CommerceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceService {
    @Autowired
    private CommerceMapper commerceMapper;
    public void addCart(Integer clothesId,Integer userId){
        commerceMapper.addCart(clothesId,userId);
    }
    public List<Clothes> showCart(Integer userId){
        return commerceMapper.showCart(userId);
    }
}
