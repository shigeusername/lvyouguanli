package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import com.example.project.entity.VO.GuideVO;
import com.example.project.service.ComplaintDaoServiceImpl;
import com.example.project.service.TourismEnterpriseDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api
public class ComplaintController {
    @Autowired
    ComplaintDaoServiceImpl complaintDaoService;
    @Autowired
    TourismEnterpriseDaoService tourismEnterpriseDaoService;

    @PostMapping(value = "findAllComplaint")
    @ResponseBody
    @ApiOperation("查看所有投诉")
    public ResultUtil findAllComplaint(@RequestBody(required = false) HashMap<String, String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        pageNum = (pageNum - 1) * pageSize;
        int size = complaintDaoService.findNumOfAllComplaint();
        List<ComplaintVO> complaintVOS = complaintDaoService.findAllComplaint(pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("size", size);
        res.put("information", complaintVOS);
        return ResultUtil.success(res);
    }

    @PostMapping(value = "findComplaintById")
    @ResponseBody
    @ApiOperation("根据id查找投诉")
    public ResultUtil findComplaintById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(complaintDaoService.findComplaintById(id));
    }


    @PostMapping(value = "findComplaintUnCoped")
    @ResponseBody
    @ApiOperation("查找所有未处理投诉")
    public ResultUtil findComplaintUnCoped(@RequestBody HashMap<String, String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        pageNum = (pageNum - 1) * pageSize;
        int size = complaintDaoService.findNumOfComplaintUnCoped();
        List<ComplaintVO> complaintVOS = complaintDaoService.findComplaintUnCoped(pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("size", size);
        res.put("information", complaintVOS);
        return ResultUtil.success(res);
    }

    @PostMapping(value = "findComplaintCoped")
    @ResponseBody
    @ApiOperation("查找所有已处理投诉")
    public ResultUtil findComplaintCoped(@RequestBody HashMap<String, String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        pageNum = (pageNum - 1) * pageSize;
        int size = complaintDaoService.findNumOfComplaintCoped();
        List<ComplaintVO> complaintVOS = complaintDaoService.findComplaintCoped(pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("size", size);
        res.put("information", complaintVOS);
        return ResultUtil.success(res);
    }

    @PostMapping(value = "AddComplaint")
    @ResponseBody
    @ApiOperation("新增投诉")
    public ResultUtil AddComplaint(@RequestBody HashMap<String, String> map) {
        int sender = Integer.parseInt(map.get("sender"));
        int enterprise_id = Integer.parseInt(map.get("enterprise_id"));
        String content = map.get("content");
        int level = Integer.parseInt(map.get("level"));
        String if_coped = map.get("if_coped");
        Date send_date = new Date(System.currentTimeMillis());
        String title = map.get("title");
        tourismEnterpriseDaoService.updateCreditByComplaint(enterprise_id, 0.2 * level);
        Complaint complaint = new Complaint(sender, enterprise_id, content, level, if_coped, send_date, title);
        return ResultUtil.success(complaintDaoService.AddComplaint(complaint));
    }

    @PostMapping(value = "DeleteComplaintById")
    @ResponseBody
    @ApiOperation("通过id删除投诉")
    public ResultUtil<Integer> DeleteComplaintById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(complaintDaoService.DeleteComplaintById(id));
    }

    @PostMapping(value = "DeleteComplaintCoped")
    @ResponseBody
    @ApiOperation("删除所有已处理投诉")
    public ResultUtil<Integer> DeleteComplaintCoped(@RequestBody HashMap<String, String> map) {
        return ResultUtil.success(complaintDaoService.DeleteComplaintCoped());
    }

    @PostMapping(value = "UpdateComplaint")
    @ResponseBody
    @ApiOperation("更改已有投诉")
    public ResultUtil<Integer> UpdateComplaint(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        int sender = Integer.parseInt(map.get("sender"));
        int enterprise_id = Integer.parseInt(map.get("enterprise_id"));
        String context = map.get("context");
        int level = Integer.parseInt(map.get("level"));
        String if_coped = map.get("if_coped");
        Date send_date = new Date(System.currentTimeMillis());
        String title = map.get("title");
        Complaint complaint = new Complaint(id, sender, enterprise_id, context, level, if_coped, send_date, title);
        return ResultUtil.success(complaintDaoService.UpdateComplaint(complaint));
    }

    @PostMapping(value = "ReviewComplaint")
    @ResponseBody
    @ApiOperation("审批投诉")
    public ResultUtil<Integer> ReviewComplaint(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String if_coped = map.get("if_coped");
        return ResultUtil.success(complaintDaoService.ReviewComplaint(id, if_coped));
    }
}
