package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.User;
import com.example.project.service.UserDaoServiceImpl;
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
    @Autowired
    private UserDaoServiceImpl userDaoService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "toLogin")
    @ResponseBody
    @ApiOperation("登录")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "user/login")
    @ResponseBody
    @ApiOperation("登录")
    public ResultUtil login(HttpServletResponse response, @RequestBody HashMap<String, String> map) throws IOException {
        // 取得参数
        String password = map.get("password");
        String validateCode = map.get("validateCode");
        String validateKey = map.get("validateKey");
        String account = map.get("account");
        System.out.println(password+"~"+validateCode+"~"+validateKey+"~"+account);
        //验证码匹配
        String validateCodeRedis = (String) redisUtil.get(validateKey);

        if (validateCodeRedis.equals(validateCode)) {//匹配验证码
            userDaoService.findUserByAccount(account);
            User user = userDaoService.findUserByAccount(account);
            if (user != null) {//查看用户是否存在
                //查找成功
                String salt = user.getSalt();
                String finalPassword = MD5Util.formPassToDBPass(password, salt);
                if (finalPassword.equals(user.getPassword())) {//匹配用户密码
                    Map<String,String> payload=new HashMap<>();
                    payload.put("account",account);
                    payload.put("password",password);
                    payload.put("id",String.valueOf(user.getId()));
                    String token = JWTUtil.getToken(payload);
                    // System.out.println("token:"+token);
                    response.setHeader("token", token);
                    //这是 郑 加的
                    response.setHeader("id", String.valueOf(user.getId()));
                    // response.sendRedirect("index.html");
                    int type = userDaoService.findTypeByAccount(account);
                    String name = userDaoService.findNameByAccount(account);
                    Map<String, Object> res = new HashMap<>();
                    res.put("flag", 1);
                    res.put("type",type);
                    res.put("name",name);
                    res.put("id",user.getId());
                    res.put("account",user.getAccount());
                    return ResultUtil.success(res);// 登陆成功
                } else {
                    Map<String, Object> res = new HashMap<>();
                    res.put("flag", 2);
                    res.put("type",3);
                    res.put("name","wrong");
                    res.put("id","wrong");
                    res.put("account","wrong");
                    return ResultUtil.success(res);//密码错误
                }
            } else {
                Map<String, Object> res = new HashMap<>();
                res.put("flag", 3);
                res.put("type",3);
                res.put("name","wrong");
                res.put("id","wrong");
                res.put("account","wrong");
                return ResultUtil.success(res);//用户名无
            }
        }else {
            Map<String, Object> res = new HashMap<>();
            res.put("flag", 0);
            res.put("type",3);
            res.put("name","wrong");
            res.put("id","wrong");
            res.put("account","wrong");
            return ResultUtil.success(res);//验证码错误
        }
    }
}