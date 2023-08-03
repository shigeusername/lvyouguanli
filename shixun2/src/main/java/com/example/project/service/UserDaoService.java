package com.example.project.service;

import com.example.project.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDaoService {
    List<User> findAll();

    //新增数据
    int add(String account, String password, String name, String salt, int type);

    //删除数据
    int delete(int sid);

    //根据id查找
    User findUserById(int sid);

    //根据name查找
    User findUserByName(String name);

    //查找是否存在账户
    Boolean findExistByAccount(String account);

    //根据account查找
    User findUserByAccount(String account);

    //更新数据
    int update(User user);

    //通过account查type
    int findTypeByAccount(String account);

    //通过id修改password
    int updatePasswordById(int id, String password);

    //通过id查salt
    String findSaltById(int id);

    //根据id查type
    int findTypeById(int id);

    //根据account查name
    String findNameByAccount(String account);

    //根据审批结果改变user的type
    int updateTypeByApplication(int user_id,String type);
}
