package com.syw.showmeshopsyw.mapper;

import com.syw.showmeshopsyw.entity.Clothes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopMapper {
    @Select("select * from clothes")
    public List<Clothes> findByPage();

    @Select("select * from clothes where id=#{clothesId}")
    public Clothes singleProduct(Integer clothesId);

    @Select("select * from clothes order by ${_parameter}")
    public List<Clothes> findByPageByCondition(String condition);

    @Select("SELECT * FROM clothes WHERE newprice BETWEEN ${_parameter}")
    public List<Clothes> findByPrice(String condition);

    @Select("SELECT * FROM clothes WHERE color=#{color}")
    public List<Clothes> findByColor(String color);

    @Select("SELECT * FROM clothes WHERE size=#{size}")
    public List<Clothes> findBySize(String size);

    @Select("SELECT * FROM clothes WHERE sex=#{sex}")
    public List<Clothes> findBySex(Integer sex);
}
