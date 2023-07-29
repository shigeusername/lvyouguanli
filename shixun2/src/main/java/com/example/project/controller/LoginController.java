package com.example.project.controller;

import com.example.project.utils.JWTUtil;
import com.example.project.utils.MD5Util;
import com.example.project.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api
public class LoginController {
//    @Autowired
//    private StudentDaoServiceImpl studentDaoService;
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @RequestMapping(value = "toLogin")
//    @ResponseBody
//    @ApiOperation("登录")
//    public String toLogin() {
//        return "login";
//    }
//
//    @RequestMapping(value = "login")
//    @ResponseBody
//    @ApiOperation("登录")
//    public String login(HttpServletResponse response,@RequestBody HashMap<String, String> map) throws IOException {
//        // 取得参数
//        String password = map.get("password");
//        String validateCode = map.get("validateCode");
//        String validateKey = map.get("validateKey");
//        String account = map.get("account");
//        System.out.println(password+"~"+validateCode+"~"+validateKey+"~"+account);
//        //验证码匹配
//        String validateCodeRedis = (String) redisUtil.get(validateKey);
//
//        if (validateCodeRedis.equals(validateCode)) {
//            //查找用户
//            studentDaoService.findStudentByAccount(account);
//            Student student = studentDaoService.findStudentByAccount(account);
//            if (student != null) {
//                //查找成功
//                String salt = student.getSalt();
//                String finalPassword = MD5Util.formPassToDBPass(password, salt);
//                if (finalPassword.equals(student.getPassword())) {
//                    Map<String,String> payload=new HashMap<>();
//                    payload.put("account",account);
//                    payload.put("password",password);
//                    payload.put("sid",String.valueOf(student.getSid()));
//                    String token = JWTUtil.getToken(payload);
//                     System.out.println("token:"+token);
//                    response.setHeader("token", token);
//                    //这是 郑 加的
//                    response.setHeader("sid", String.valueOf(student.getSid()));
//                    // response.sendRedirect("index.html");
//                    return "登陆成功";
//                } else {
//                    return "密码错误";
//                }
//            } else {
//                return "用户名无";
//            }
//        }else {
//            return "验证码错误";
//        }
//    }

}
