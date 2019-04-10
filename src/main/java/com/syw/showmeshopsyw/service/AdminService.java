package com.syw.showmeshopsyw.service;

import com.syw.showmeshopsyw.entity.Admin;
import com.syw.showmeshopsyw.entity.Clothes;
import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin login(Admin admin){
        return adminMapper.login(admin);
    }

    public List<User> findAllUser(){
        return adminMapper.findAllUser();
    }
    public void addUser(User user){
        adminMapper.addUser(user);
    }
    public void editUser(User user){
        adminMapper.editUser(user);
    }
    public void deleteUser(Integer id){
        adminMapper.deleteUser(id);
    }
    public User get(Integer id){
        return adminMapper.get(id);
    }

    public List<Clothes> findAllClothes(){
        return adminMapper.findAllColthes();
    }
    public void addClothes(Clothes clothes){
        adminMapper.addClothes(clothes);
    }
    public Clothes getClothesByid(Integer id){
        return adminMapper.getClothesById(id);
    }
    public void editClothes(Clothes clothes){
        adminMapper.editClothes(clothes);
    }
}
