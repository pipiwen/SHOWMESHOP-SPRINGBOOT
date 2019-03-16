package com.syw.showmeshopsyw.mapper;

import com.syw.showmeshopsyw.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select username,password from t_user where id=#{id}")
    public User get(Integer id);

    @Select("select id,username,password from t_user where username=#{username} and password=#{password}")
    public User login(User user);

    @Insert("insert into t_user(username,password)values(#{username},#{password})")
    public void register(User user);
}
