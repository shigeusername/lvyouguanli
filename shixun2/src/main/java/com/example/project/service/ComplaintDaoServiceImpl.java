package com.example.project.service;

import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ComplaintDaoServiceImpl")
public class ComplaintDaoServiceImpl implements ComplaintDaoService {
    @Autowired
    ComplaintDaoService complaintDaoService;

    @Override
    public List<ComplaintVO> findAllComplaint() {
        return complaintDaoService.findAllComplaint();
    }

    @Override
    public ComplaintVO findComplaintById(int id) {
        return complaintDaoService.findComplaintById(id);
    }

    @Override
    public List<ComplaintVO> findComplaintBySender(int sender) {
        return complaintDaoService.findComplaintBySender(sender);
    }

    @Override
    public List<ComplaintVO> findComplaintByEnterprise(int enterprise_id) {
        return complaintDaoService.findComplaintByEnterprise(enterprise_id);
    }

    @Override
    public List<ComplaintVO> findComplaintByLevel(int level) {
        return complaintDaoService.findComplaintByLevel(level);
    }

    @Override
    public List<ComplaintVO> findComplaintUnCoped() {
        return complaintDaoService.findComplaintUnCoped();
    }

    @Override
    public List<ComplaintVO> findComplaintCoped() {
        return complaintDaoService.findComplaintCoped();
    }

    @Override
    public int AddComplaint(Complaint complaint) {
        return complaintDaoService.AddComplaint(complaint);
    }

    @Override
    public int DeleteComplaintById(int id) {
        return complaintDaoService.DeleteComplaintById(id);
    }

    @Override
    public int DeleteComplaintCoped() {
        return complaintDaoService.DeleteComplaintCoped();
    }

    @Override
    public int UpdateComplaint(Complaint complaint) {
        return complaintDaoService.UpdateComplaint(complaint);
    }
}
