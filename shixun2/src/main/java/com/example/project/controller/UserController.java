package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.User;
import com.example.project.service.UserDaoServiceImpl;
import com.example.project.utils.MD5Util;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api
public class UserController {
    @Autowired
    private UserDaoServiceImpl userDaoService;

    @RequestMapping(value = "user/modpassword")
    @ResponseBody
    ResultUtil modpassword (@RequestBody HashMap<String, String> map){
        String password = map.get("password");
        int id = Integer.parseInt(map.get("id"));
        String salt = userDaoService.findSaltById(id);
        String finalPassword = MD5Util.formPassToDBPass(password, salt);
        System.out.println(finalPassword);
        userDaoService.updatePasswordById(id, finalPassword);
        return ResultUtil.success(1);
    }

    @RequestMapping(value = "user/getUserInfo")
    @ResponseBody
    ResultUtil getUserInfo (@RequestBody HashMap<String, String> map){
        String name = map.get("name");
        User user = userDaoService.findUserByName(name);
        String account = user.getAccount();
        Map<String, Object> res = new HashMap<>();
        res.put("name", name);
        res.put("account",account);
        return ResultUtil.success(res);
    }
}