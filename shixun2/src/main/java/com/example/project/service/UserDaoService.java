package com.example.project.service;



import com.example.project.entity.User;

public interface UserDaoService {

    //注册新用户
    int add(User user);

    //通过name查找用户
    Boolean findUserByAccount(String account);

    int updatePasswordById(int id, String password);
}
