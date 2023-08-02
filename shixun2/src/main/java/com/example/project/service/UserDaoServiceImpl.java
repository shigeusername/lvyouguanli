package com.example.project.service;

import com.example.project.dao.UserDao;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserDaoServiceImpl")
public class UserDaoServiceImpl implements UserDaoService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int add(String account, String password, String name, String salt, int type) {
        System.out.println(name + "   " + password + " " + account);
        return userDao.add(account, password, name, salt, type);
    }

    @Override
    public int delete(int sid) {
        return userDao.delete(sid);
    }

    @Override
    public User findUserById(int sid) {
        return userDao.findUserById(sid);
    }

    @Override
    public User findUserByName(String sname) {
        return userDao.findUserByName(sname);
    }

    @Override
    public Boolean findExistByAccount(String account) {
        return userDao.findExistByAccount(account);
    }

    @Override
    public User findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int findTypeByAccount(String account){return userDao.findTypeByAccount(account);}

    @Override
    public int updatePasswordById(int id, String password){
        return userDao.updatePasswordById(id, password);
    }

    @Override
    public String findSaltById(int id){
        return userDao.findSaltById(id);
    }

    @Override
    public int findTypeById(int id){return userDao.findTypeById(id);}

    @Override
    public String findNameByAccount(String account){return userDao.findNameByAccount(account);}
}
