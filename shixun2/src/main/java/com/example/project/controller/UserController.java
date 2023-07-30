package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.User;
import com.example.project.service.UserDaoServicelmpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Api
@RequestMapping("user")
public class UserController {
    @Autowired
    UserDaoServicelmpl userDaoServicelmpl;

    @PostMapping("/register")
    ResultUtil add(@RequestBody HashMap<String, String> map){
        String account = map.get("account");
        String password = map.get("password");
        String name = map.get("name");
        String salt = "dascawesda";
        Boolean flag = userDaoServicelmpl.findUserByAccount(account);
        System.out.println(flag);
        if(flag == true) return ResultUtil.success("0");
        User user = new User(name,account,password,salt);
        userDaoServicelmpl.add(user);
        return ResultUtil.success("1");
    }

    @PostMapping("/modpassword")
    ResultUtil modpassword(@RequestBody HashMap<String, String> map){
        String password = map.get("password");
        int id = Integer.parseInt(map.get("id"));
        userDaoServicelmpl.updatePasswordById(id, password);
        return ResultUtil.success("1");
    }
}
