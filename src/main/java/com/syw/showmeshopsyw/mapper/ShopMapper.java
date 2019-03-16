package com.syw.showmeshopsyw.mapper;

import com.syw.showmeshopsyw.entity.Clothes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopMapper {
    @Select("select * from clothes")
    public List<Clothes> findByPage();
}
