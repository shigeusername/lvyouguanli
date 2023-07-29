package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.VO.WarningVO;
import com.example.project.entity.Warning;
import com.example.project.service.WarningDaoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WarningController {
    @Autowired
    WarningDaoServiceImpl warningDaoService;

    @GetMapping(value = "findAllWarning")
    @ResponseBody
    @ApiOperation("查看所有警告")
    public ResultUtil findAllWarning(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarning());
    }

    @GetMapping(value = "findWarningById")
    @ResponseBody
    @ApiOperation("根据id查找警告")
    public ResultUtil findWarningById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(warningDaoService.findWarningById(id));
    }

    @GetMapping(value = "findAllWarningNeedCope")
    @ResponseBody
    @ApiOperation("查看所有需审批警告")
    public ResultUtil findAllWarningNeedCope(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningNeedCope());
    }

    @GetMapping(value = "findAllWarningNoRequired")
    @ResponseBody
    @ApiOperation("查看所有直接发布警告")
    public ResultUtil findAllWarningNoRequired(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningNoRequired());
    }

    @GetMapping(value = "findAllWarningCoping")
    @ResponseBody
    @ApiOperation("查看所有正在处理警告")
    public ResultUtil findAllWarningCoping(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningCoping());
    }

    @GetMapping(value = "findAllWarningDone")
    @ResponseBody
    @ApiOperation("查看所有处理完成警告")
    public ResultUtil findAllWarningDone(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningDone());
    }

    @GetMapping(value = "AddWarning")
    @ResponseBody
    @ApiOperation("新增警告")
    public ResultUtil AddWarning(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String content = map.get("content");
        int sender = Integer.parseInt(map.get("sender"));
        String need_cope = map.get("need_cope");
        Date send_time = new Date();
        Warning warning = new Warning(id, content, sender, need_cope, send_time);
        return ResultUtil.success(warningDaoService.AddWarning(warning));
    }

    @GetMapping(value = "DeleteWarningById")
    @ResponseBody
    @ApiOperation("根据id删除警告")
    public ResultUtil<Integer> DeleteWarningById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(warningDaoService.DeleteWarningById(id));
    }

    @GetMapping(value = "DeleteWarningCoped")
    @ResponseBody
    @ApiOperation("删除所有已处理警告")
    public ResultUtil<Integer> DeleteWarningCoped(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.DeleteWarningCoped());
    }

    @GetMapping(value = "UpdateWarning")
    @ResponseBody
    @ApiOperation("UpdateWarning")
    public ResultUtil<Integer> UpdateWarning(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String content = map.get("content");
        int sender = Integer.parseInt(map.get("sender"));
        String need_cope = map.get("need_cope");
        Date send_time = new Date();
        Warning warning = new Warning(id, content, sender, need_cope, send_time);
        return ResultUtil.success(warningDaoService.UpdateWarning(warning));
    }
}
