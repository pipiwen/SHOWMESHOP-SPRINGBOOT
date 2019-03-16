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
}
