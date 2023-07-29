package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.Application;
import com.example.project.entity.Guide;
import com.example.project.service.GuideDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Api
public class GuideController {
    @Autowired
    GuideDaoServiceImpl guideDaoService;

    @GetMapping(value = "findAllGuide")
    @ResponseBody
    @ApiOperation("查询所有导游（管理员端）")
    public ResultUtil findAllGuide(@RequestBody HashMap<String, String> map){
        return ResultUtil.success(guideDaoService.findAllGuide());
    }

    @GetMapping(value = "findGuideById")
    @ResponseBody
    @ApiOperation("根据id查找导游（管理员端）")
    public ResultUtil findGuideById(@RequestBody HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(guideDaoService.findGuideById(id));
    }

    @DeleteMapping(value = "deleteGuideById")
    @ResponseBody
    @ApiOperation("根据id删除导游（管理员端）")
    public ResultUtil deleteGuideById(@RequestBody HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(guideDaoService.deleteGuideById(id));
    }

    @PostMapping(value = "updateGuideById")
    @ResponseBody
    @ApiOperation("根据id修改导游信息（管理员端）")
    public ResultUtil updateGuideById(@RequestBody HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        int affiliated_agency=Integer.parseInt(map.get("affiliated_agency"));
        String information=map.get("information");
        String academic_degree=map.get("academic_degree");
        String speciality=map.get("speciality");
        String school =map.get("school");
        Guide guide=new Guide(id,affiliated_agency,0,information,academic_degree,speciality,school);
        return ResultUtil.success(guideDaoService.updateGuideById(guide));
    }

    @GetMapping(value = "findGuideVaguely")
    @ResponseBody
    @ApiOperation("模糊查询导游（管理员端）")
    public ResultUtil findGuideVaguely(@RequestBody HashMap<String, String> map){
        String str=map.get("str");
        str="%"+str+"%";
        return ResultUtil.success(guideDaoService.findGuideVaguely(str));
    }

    @PostMapping(value = "guideApplyItinerary")
    @ResponseBody
    @ApiOperation("导游申领行程单（导游端）")
    public ResultUtil guideApplyItinerary(@RequestBody HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        int itinerary_id=Integer.parseInt(map.get("itinerary_id"));
        return ResultUtil.success(guideDaoService.guideApplyItinerary(id,itinerary_id));
    }

    @GetMapping(value = "findGuideByAgency_id")
    @ResponseBody
    @ApiOperation("根据旅行社id查找导游")
    public ResultUtil findGuideByAgency_id(@RequestBody HashMap<String, String> map){
        int agency_id = Integer.parseInt(map.get("agency_id"));
        return ResultUtil.success(guideDaoService.findGuideByAgency_id(agency_id));
    }
}