package com.example.project.controller;

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
//    @Autowired
//    private StudentDaoServiceImpl studentDaoService;
//
//    @RequestMapping(value = "register")
//    @ResponseBody
//    @ApiOperation("注册")
//
//    public String register(@RequestBody HashMap<String,String> map) {
//        String sname = map.get("sname");
//        String password = map.get("password");
//        String account = map.get("account");
//        if(studentDaoService.findExistByAccount(account) != null) {
//            return "account已存在";
//        }else {
//            String salt = RandomUtil.randomString(10);
//            String finalPassword = MD5Util.formPassToDBPass(password, salt);
//            Student student = new Student(0,account, finalPassword,sname,salt);
//            studentDaoService.add(student);
//            return "注册成功";
//        }
//    }
}
