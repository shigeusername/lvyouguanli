package com.example.project.controller;


import com.example.project.common.ResultUtil;
import com.example.project.entity.Application;
import com.example.project.entity.Guide;
import com.example.project.entity.VO.ApplicationVO;
import com.example.project.service.ApplicationDaoServiceImpl;
import com.example.project.service.GuideDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api
public class ApplicationController {
    @Autowired
    ApplicationDaoServiceImpl applicationDaoService;
    @Autowired
    GuideDaoServiceImpl guideDaoService;

    @PostMapping(value = "addApplication")
    @ResponseBody
    @ApiOperation("用户提交申请表")
    public ResultUtil addApplication(@RequestBody HashMap<String, String> map){
        int user_id = Integer.parseInt(map.get("user_id"));
        String content=map.get("content");
        int agency_id=Integer.parseInt(map.get("agency_id"));
        String information=map.get("information");
        String academic_degree=map.get("academic_degree");
        String speciality=map.get("speciality");
        String school =map.get("school");
        Application a=new Application(0,user_id,content,null,agency_id,information,academic_degree,speciality,school);
        return ResultUtil.success(applicationDaoService.addApplication(a));
    }

    @PostMapping(value = "ifSubmittedApplication")
    @ResponseBody
    @ApiOperation("用户是否提交过申请")
    public ResultUtil ifSubmittedApplication(@RequestBody  HashMap<String, String> map){
        int user_id = Integer.parseInt(map.get("user_id"));
        Map<String,Object> res=new HashMap<>();

        res.put("if_submitted",applicationDaoService.ifSubmittedApplication(user_id));
        return ResultUtil.success(res);
    }

    //需结合其他接口
    @PostMapping(value = "findApplicationByUserId")
    @ResponseBody
    @ApiOperation("查看用户的申请表")
    public ResultUtil findApplicationByUserId(@RequestBody  HashMap<String, String> map){
        int user_id = Integer.parseInt(map.get("user_id"));
        Map<String,Object> res=new HashMap<>();

//        Application a=applicationDaoService.findApplicationByUserId(user_id);
//        User user=userDaoService.findUserById(user_id);
//        Tourism_enterprise te=tour_enterpriseDaoService.findTourism_enterpriseById(a.getAgency_id());
//        res.put("ApplicationVO",avo);
//        res.put("User",user);
//        res.put("Tourism_enterprise",te);

        return ResultUtil.success(applicationDaoService.findApplicationByUserId(user_id));
    }

    @PostMapping(value = "updateApplication")
    @ResponseBody
    @ApiOperation("修改申请表（用户端）")
    public ResultUtil updateApplication(@RequestBody  HashMap<String, String> map){
        int user_id = Integer.parseInt(map.get("user_id"));
        String content=map.get("content");
        int agency_id=Integer.parseInt(map.get("agency_id"));
        String information=map.get("information");
        String academic_degree=map.get("academic_degree");
        String speciality=map.get("speciality");
        String school =map.get("school");
        Application a=new Application(0,user_id,content,null,agency_id,information,academic_degree,speciality,school);

        return ResultUtil.success(applicationDaoService.updateApplication(a));
    }

    @GetMapping(value = "findAllApplication")
    @ResponseBody
    @ApiOperation("查询所有申请表（管理员端）")
    public ResultUtil<List<ApplicationVO>> findAllApplication(){
        return ResultUtil.success(applicationDaoService.findAllApplication());
    }

    @PostMapping(value = "findApplicationById")
    @ResponseBody
    @ApiOperation("根据申请表的id查找申请表（管理端）")
    public ResultUtil findApplicationById(@RequestBody  HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(applicationDaoService.findApplicationById(id));
    }

    @PostMapping(value = "reviewApplication")
    @ResponseBody
    @ApiOperation("审批申请表（管理员端并且更新guide表）")
    public ResultUtil reviewApplication(@RequestBody  HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        String if_succeed=map.get("if_succeed");

        Application a= applicationDaoService.findApplicationById(id);

        if(applicationDaoService.reviewApplication(id,if_succeed)==1){
            Guide guide=new Guide(a.getUser_id(),a.getAgency_id(),100,a.getInformation(),a.getAcademic_degree(),a.getSpeciality(),a.getSchool());

            return ResultUtil.success(guideDaoService.addGuide(guide));
        }

        return ResultUtil.success(applicationDaoService.reviewApplication(id,if_succeed));
    }

    @DeleteMapping(value = "deleteApplicationById")
    @ResponseBody
    @ApiOperation("根据id删除申请表（管理员端）")
    public ResultUtil deleteApplicationById(@RequestBody  HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(applicationDaoService.deleteApplicationById(id));
    }

    @PostMapping(value = "selectApplicationByIf_succeed")
    @ResponseBody
    @ApiOperation("根据if_succeed筛选申请表（管理员端）")
    public ResultUtil selectApplicationByIf_succeed(@RequestBody  HashMap<String, String> map){
        String if_succeed=map.get("if_succeed");
        return ResultUtil.success(applicationDaoService.selectApplicationByIf_succeed(if_succeed));
    }

}
