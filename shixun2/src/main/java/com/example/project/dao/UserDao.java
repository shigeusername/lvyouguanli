package com.example.project.dao;

import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    List<User> findAll();

    //新增数据
    int add(String account, String password, String name, String salt, int type);

    //删除数据
    Integer delete(Integer sid);

    //根据id查找
    User findUserById(Integer sid);

    //根据name查找
    User findUserByName(String sname);

    //查找是否存在账户
    Boolean findExistByAccount(String account);

    //根据account查找
    User findUserByAccount(String account);

    //更新数据
    int update(User user);

    //通过id查类型
    int findTypeByAccount(String account);

    //通过id更新password
    int updatePasswordById(int id, String password);

    //通过id查salt
    String findSaltById(int id);

    //通过id查type
    int findTypeById(int id);

    //根据account查name
    String findNameByAccount(String account);

}