package com.syw.showmeshopsyw.mapper;
import com.syw.showmeshopsyw.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommerceMapper {
    @Insert("insert into cart(clothes_id,user_id,amount,subtotal)values(#{id},#{userId},1,#{price})")
    public void addCart(Map<String,Object> jsonData);

    @Select("select a.id, name,picAddress1,newPrice,amount from cart a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> showCart(Integer userId);

    @Insert("insert into compare(clothes_id,user_id)values(#{clothesId},#{userId})")
    public void addCompare(@Param("clothesId") Integer clothesId,@Param("userId") Integer userId);

    @Select("select name,picAddress1,newPrice,color,rating from compare a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> showCompare(Integer userId);

    @Delete("delete from cart where id=#{cartId}")
    public void delCart(Integer cartId);

    @Select("select id,name,pno from province")
    public List<Province>findAllProvince();

    @Select("select id,name,cno from city where cno=#{pno}")
    public List<City>findCityByProvince(String pno);

    @Update("update cart set amount=#{amount},subtotal=#{subtotal} where id=#{id}")
    public void modifyAmount(Map<String,Object> jsonData);

    @Select("select b.id, name,picAddress1,newPrice,amount,subtotal from cart a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> showOrder(Integer userId);

    @Select("select clothes_id clothesId,amount,subtotal,user_id userId from cart where user_id=#{userId}")
    public List<Cart> findCart(Integer userId);

    @Insert("insert into order1(clothes_id,amount,subtotal,user_id)values(#{clothesId}," +
            "#{amount},#{subtotal},#{userId})")
    public void toOrder(Cart cart);

    @Delete("delete from cart where user_id=#{userId}")
    public void delCartByUserId(Integer userId);

    @Insert("insert into user_info(name,phone,address,ordernote,user_id)values(#{name}," +
            "#{phone},#{address},#{ordernote},#{userId})")
    public void addUserInfo(Map<String,Object>jsonData);

    @Select("select b.id, name,picAddress1,newPrice,amount,subtotal from order1 a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId}")
    public List<Clothes> completeOrder(Integer userId);
    @Select("select * from user_info where user_id=#{userId}")
    public UserInfo userInfo(Integer userId);

}
