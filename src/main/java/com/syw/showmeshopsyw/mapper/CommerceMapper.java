package com.syw.showmeshopsyw.mapper;
import com.syw.showmeshopsyw.entity.Clothes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommerceMapper {
    @Insert("insert into cart(clothes_id,user_id)values(#{clothesId},#{userId})")
    public void addCart(@Param("clothesId") Integer clothesId,@Param("userId") Integer userId);

    @Select("select a.id, name,picAddress1,newPrice from cart a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> showCart(Integer userId);

    @Insert("insert into compare(clothes_id,user_id)values(#{clothesId},#{userId})")
    public void addCompare(@Param("clothesId") Integer clothesId,@Param("userId") Integer userId);

    @Select("select name,picAddress1,newPrice,color,rating from compare a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> showCompare(Integer userId);

    @Delete("delete from cart where id=#{cartId}")
    public void delCart(Integer cartId);
}
