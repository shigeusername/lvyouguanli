package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.User;
import com.example.project.service.UserDaoServiceImpl;
import com.example.project.utils.MD5Util;
import com.power.common.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@Api
public class RegisterController {
    @Autowired
    private UserDaoServiceImpl userDaoService;

    @RequestMapping(value = "user/register")
    @ResponseBody
    @ApiOperation("注册")
    
    public ResultUtil register(@RequestBody HashMap<String,String> map) {
        String sname = map.get("name");
        String password = map.get("password");
        String account = map.get("account");
        if(userDaoService.findExistByAccount(account) != null) {
            return ResultUtil.success(0);
        }else {
            String salt = RandomUtil.randomString(10);
            String finalPassword = MD5Util.formPassToDBPass(password, salt);
            User user = new User(account, finalPassword,sname,salt);
            userDaoService.add(user);
            return ResultUtil.success(1);
        }
    }
}