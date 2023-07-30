package com.example.project.service;

import com.example.project.dao.ComplaintDao;
import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ComplaintDaoServiceImpl")

public class ComplaintDaoServiceImpl implements ComplaintDaoService {

    @Autowired
    ComplaintDao complaintDao;

    @Override
    public List<ComplaintVO> findAllComplaint() {
        return complaintDao.findAllComplaint();
    }

    @Override
    public ComplaintVO findComplaintById(int id) {
        return complaintDao.findComplaintById(id);
    }

    @Override
    public List<ComplaintVO> findComplaintBySender(int sender) {
        return complaintDao.findComplaintBySender(sender);
    }

    @Override
    public List<ComplaintVO> findComplaintByEnterprise(int enterprise_id) {
        return complaintDao.findComplaintByEnterprise(enterprise_id);
    }

    @Override
    public List<ComplaintVO> findComplaintByLevel(int level) {
        return complaintDao.findComplaintByLevel(level);
    }

    @Override
    public List<ComplaintVO> findComplaintUnCoped() {
        return complaintDao.findComplaintUnCoped();
    }

    @Override
    public List<ComplaintVO> findComplaintCoped() {
        return complaintDao.findComplaintCoped();
    }

    @Override
    public int AddComplaint(Complaint complaint) {
        return complaintDao.AddComplaint(complaint);
    }

    @Override
    public int DeleteComplaintById(int id) {
        return complaintDao.DeleteComplaintById(id);
    }

    @Override
    public int DeleteComplaintCoped() {
        return complaintDao.DeleteComplaintCoped();
    }

    @Override
    public int UpdateComplaint(Complaint complaint) {
        return complaintDao.UpdateComplaint(complaint);
    }
}
