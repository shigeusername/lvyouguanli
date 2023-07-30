package com.example.project.service;


import com.example.project.dao.UserDao;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserDaoServicempl")
public class UserDaoServicelmpl implements UserDaoService{
    @Autowired
    UserDao userDao;

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public Boolean findUserByAccount(String account){return userDao.findUserByAccount(account);}

    @Override
    public int updatePasswordById(int id, String password){return userDao.updatePasswordById(id, password);};
}
