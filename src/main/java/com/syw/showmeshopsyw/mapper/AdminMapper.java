package com.syw.showmeshopsyw.mapper;

import com.syw.showmeshopsyw.entity.Admin;
import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.entity.Order;
import com.syw.showmeshopsyw.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select id,name,password from admin where name=#{name} and password=#{password}")
    public Admin login(Admin admin);

    @Select("select * from t_user")
    public List<User> findAllUser();

    @Select("select * from t_user where id=#{id}")
    public User get(Integer id);

    @Insert("insert into t_user(username,password)values(#{username},#{password})")
    public void addUser(User user);

    @Update("update t_user set username=#{username},password=#{password} where id=#{id}")
    public void editUser(User user);

    @Delete("delete from t_user where id=#{id}")
    public void deleteUser(Integer id);

    @Select("select * from clothes")
    public List<Clothes> findAllColthes();

    @Insert("insert into clothes(name,color,size,sex,picaddress1,picaddress2,oldprice,newprice,rating)values(#{name},#{color}," +
            "#{size},#{sex},#{picAddress1},#{picAddress2},#{oldPrice},#{newPrice},#{rating})")
    public void addClothes(Clothes clothes);

    @Select("select * from clothes where id=#{id}")
    public Clothes getClothesById(Integer id);

    @Update("update clothes set name=#{name},color=#{color},size=#{size},sex=#{sex}," +
            "oldprice=#{oldprice},newprice=#{newprice},rating=#{rating}")
    public void editClothes(Clothes clothes);

    @Select("select a.user_id id, b.username,SUM(subtotal) total,del_flag from order1 a,t_user b  " +
            "WHERE a.user_id=b.id group by user_id,del_flag")
    public List<Order> findAllOrder();

    @Select("select b.id, name,amount,subtotal from order1 a,clothes b " +
            "where a.clothes_id=b.id and a.user_id=#{userId} and a.del_flag=#{del_flag}")
    public List<Clothes> findClothesByUserId(@Param("userId") Integer userId,
                                             @Param("del_flag")Integer del_flag);

    @Delete("delete from order1 where user_id=#{userId} and del_flag=0")
    public void delOrder(Integer userId);
}
