package com.syw.showmeshopsyw.mapper;
import com.syw.showmeshopsyw.entity.Clothes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommerceMapper {
    @Insert("insert into cart(clothes_id,user_id)values(#{clothesId},#{userId})")
    public void addCart(@Param("clothesId") Integer clothesId,@Param("userId") Integer userId);

    @Select("select name,picAddress1,newPrice from cart a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> showCart(Integer userId);
}
