package com.syw.showmeshopsyw.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
@Autowired
    private ShopMapper shopMapper;
    public PageInfo<Clothes> findByPage(int pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Clothes>list=shopMapper.findByPage();
        PageInfo<Clothes>pageInfo=new PageInfo<Clothes>(list);
        return pageInfo;
}
    public PageInfo<Clothes> findByPageByCondition(int pageNum,Integer pageSize,String condition){
        PageHelper.startPage(pageNum,pageSize);
        List<Clothes>list=shopMapper.findByPageByCondition(condition);
        PageInfo<Clothes>pageInfo=new PageInfo<Clothes>(list);
        return pageInfo;
    }

    public PageInfo<Clothes> findByByPrice(int pageNum,Integer pageSize,String condition){
        PageHelper.startPage(pageNum,pageSize);
        List<Clothes>list=shopMapper.findByPrice(condition);
        PageInfo<Clothes>pageInfo=new PageInfo<Clothes>(list);
        return pageInfo;
    }
    public PageInfo<Clothes> findByColor(int pageNum,Integer pageSize,String color){
        PageHelper.startPage(pageNum,pageSize);
        List<Clothes>list=shopMapper.findByColor(color);
        PageInfo<Clothes>pageInfo=new PageInfo<Clothes>(list);
        return pageInfo;
    }

    public PageInfo<Clothes> findBySize(int pageNum,Integer pageSize,String size){
        PageHelper.startPage(pageNum,pageSize);
        List<Clothes>list=shopMapper.findBySize(size);
        PageInfo<Clothes>pageInfo=new PageInfo<Clothes>(list);
        return pageInfo;
    }
    public PageInfo<Clothes> findBySex(int pageNum,Integer pageSize,Integer sex){
        PageHelper.startPage(pageNum,pageSize);
        List<Clothes>list=shopMapper.findBySex(sex);
        PageInfo<Clothes>pageInfo=new PageInfo<Clothes>(list);
        return pageInfo;
    }


    public Clothes singleProduct(Integer clothesId){
        return shopMapper.singleProduct(clothesId);
    }
}
