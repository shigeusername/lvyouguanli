package com.example.project.dao;


import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    int add(User user);

    Boolean findUserByAccount(String account);

    int updatePasswordById(int id, String password);


}
