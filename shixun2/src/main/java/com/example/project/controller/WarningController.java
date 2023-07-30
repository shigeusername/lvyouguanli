package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.Warning;
import com.example.project.service.WarningDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

@RestController
@Api
public class WarningController {
    @Autowired
    WarningDaoServiceImpl warningDaoService;

    @PostMapping(value = "findAllWarning")
    @ResponseBody
    @ApiOperation("查看所有警告")
    public ResultUtil findAllWarning(@RequestBody(required = false) HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarning());
    }

    @PostMapping(value = "findWarningById")
    @ResponseBody
    @ApiOperation("根据id查找警告")
    public ResultUtil findWarningById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(warningDaoService.findWarningById(id));
    }

    @PostMapping(value = "findAllWarningNeedCope")
    @ResponseBody
    @ApiOperation("查看所有需审批警告")
    public ResultUtil findAllWarningNeedCope(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningNeedCope());
    }

    @PostMapping(value = "findAllWarningNoRequired")
    @ResponseBody
    @ApiOperation("查看所有直接发布警告")
    public ResultUtil findAllWarningNoRequired(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningNoRequired());
    }

    @PostMapping(value = "findAllWarningCoping")
    @ResponseBody
    @ApiOperation("查看所有正在处理警告")
    public ResultUtil findAllWarningCoping(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningCoping());
    }

    @PostMapping(value = "findAllWarningDone")
    @ResponseBody
    @ApiOperation("查看所有处理完成警告")
    public ResultUtil findAllWarningDone(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.findAllWarningDone());
    }

    @PostMapping(value = "AddWarning")
    @ResponseBody
    @ApiOperation("新增警告")
    public ResultUtil AddWarning(@RequestBody HashMap<String, String> map) {
        String content = map.get("content");
        int sender = Integer.parseInt(map.get("sender"));
        String need_cope = map.get("need_cope");
        Timestamp send_time = new Timestamp(System.currentTimeMillis());
        String title = map.get("title");
        Warning warning = new Warning(content, sender, need_cope, send_time, title);
        return ResultUtil.success(warningDaoService.AddWarning(warning));
    }

    @PostMapping(value = "DeleteWarningById")
    @ResponseBody
    @ApiOperation("根据id删除警告")
    public ResultUtil<Integer> DeleteWarningById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(warningDaoService.DeleteWarningById(id));
    }

    @PostMapping(value = "DeleteWarningCoped")
    @ResponseBody
    @ApiOperation("删除所有已处理警告")
    public ResultUtil<Integer> DeleteWarningCoped(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(warningDaoService.DeleteWarningCoped());
    }

    @PostMapping(value = "UpdateWarning")
    @ResponseBody
    @ApiOperation("UpdateWarning")
    public ResultUtil<Integer> UpdateWarning(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String content = map.get("content");
        int sender = Integer.parseInt(map.get("sender"));
        String need_cope = map.get("need_cope");
        Timestamp send_time = new Timestamp(System.currentTimeMillis());
        String title = map.get("title");
        Warning warning = new Warning(id, content, sender, need_cope, send_time, title);
        return ResultUtil.success(warningDaoService.UpdateWarning(warning));
    }
}
