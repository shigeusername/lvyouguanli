package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import com.example.project.entity.Complaint;
import com.example.project.service.ComplaintDaoService;
import com.example.project.service.ComplaintDaoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ComplaintController {
    @Autowired
    ComplaintDaoServiceImpl complaintDaoService;
    @GetMapping(value = "findAllComplaint")
    @ResponseBody
    @ApiOperation("查看所有投诉")
    public ResultUtil findAllComplaint(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(complaintDaoService.findAllComplaint());
    }

    @GetMapping(value = "findComplaintById")
    @ResponseBody
    @ApiOperation("根据id查找投诉")
    public ResultUtil findComplaintById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(complaintDaoService.findComplaintById(id));
    }

    @GetMapping(value = "findComplaintBySender")
    @ResponseBody
    @ApiOperation("根据投诉者查找投诉")
    public ResultUtil findComplaintBySender(@RequestBody HashMap<String, String> map) {
        int sender = Integer.parseInt(map.get("sender"));
        return ResultUtil.success(complaintDaoService.findComplaintBySender(sender));
    }

    @GetMapping(value = "findComplaintByEnterprise")
    @ResponseBody
    @ApiOperation("根据企业查找投诉")
    public ResultUtil findComplaintByEnterprise(@RequestBody HashMap<String, String> map) {
        int enterprise_id = Integer.parseInt(map.get("enterprise_id"));
        return ResultUtil.success(complaintDaoService.findComplaintByEnterprise(enterprise_id));
    }

    @GetMapping(value = "findComplaintByLevel")
    @ResponseBody
    @ApiOperation("根据程度查找投诉")
    public ResultUtil findComplaintByLevel(@RequestBody HashMap<String, String> map) {
        int level = Integer.parseInt(map.get("level"));

        return ResultUtil.success(complaintDaoService.findComplaintByLevel(level));
    }

    @GetMapping(value = "findComplaintUnCoped")
    @ResponseBody
    @ApiOperation("查找所有未处理投诉")
    public ResultUtil findComplaintUnCoped(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(complaintDaoService.findComplaintUnCoped());
    }

    @GetMapping(value = "AddComplaint")
    @ResponseBody
    @ApiOperation("新增投诉")
    public ResultUtil AddComplaint(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        int sender = Integer.parseInt(map.get("sender"));
        int enterprise_id = Integer.parseInt(map.get("enterprise_id"));
        String context = map.get("context");
        int level = Integer.parseInt(map.get("level"));
        String if_coped = map.get("if_coped");
        Date send_date = new Date();
        Complaint complaint = new Complaint(id,sender,enterprise_id,context,level,if_coped,send_date);
        return ResultUtil.success(complaintDaoService.AddComplaint(complaint));
    }

    @GetMapping(value = "DeleteComplaintById")
    @ResponseBody
    @ApiOperation("通过id删除投诉")
    public ResultUtil<Integer> DeleteComplaintById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(complaintDaoService.DeleteComplaintById(id));
    }

    @GetMapping(value = "DeleteComplaintCoped")
    @ResponseBody
    @ApiOperation("删除所有已处理投诉")
    public ResultUtil<Integer> DeleteComplaintCoped(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(complaintDaoService.DeleteComplaintCoped());
    }

    @GetMapping(value = "UpdateComplaint")
    @ResponseBody
    @ApiOperation("更改已有投诉")
    public ResultUtil<Integer> UpdateComplaint(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        int sender = Integer.parseInt(map.get("sender"));
        int enterprise_id = Integer.parseInt(map.get("enterprise_id"));
        String context = map.get("context");
        int level = Integer.parseInt(map.get("level"));
        String if_coped = map.get("if_coped");
        Date send_date = new Date();
        Complaint complaint = new Complaint(id,sender,enterprise_id,context,level,if_coped,send_date);
        return ResultUtil.success(complaintDaoService.UpdateComplaint(complaint));
    }
}
