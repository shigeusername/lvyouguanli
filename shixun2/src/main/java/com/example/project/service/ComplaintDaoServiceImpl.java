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
    public List<ComplaintVO> findAllComplaint(int pageNum, int pageSize) {
        return complaintDao.findAllComplaint(pageNum, pageSize);
    }

    @Override
    public ComplaintVO findComplaintById(int id) {
        return complaintDao.findComplaintById(id);
    }


    @Override
    public List<ComplaintVO> findComplaintUnCoped(int pageNum, int pageSize) {
        return complaintDao.findComplaintUnCoped(pageNum, pageSize);
    }

    @Override
    public List<ComplaintVO> findComplaintCoped(int pageNum, int pageSize) {
        return complaintDao.findComplaintCoped(pageNum,pageSize);
    }

    @Override
    public int findNumOfAllComplaint() {
        return complaintDao.findNumOfAllComplaint();
    }

    @Override
    public int findNumOfComplaintUnCoped() {
        return complaintDao.findNumOfComplaintUnCoped();
    }

    @Override
    public int findNumOfComplaintCoped() {
        return complaintDao.findNumOfComplaintCoped();
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

    @Override
    public int ReviewComplaint(int id, String if_coped) {
        return complaintDao.ReviewComplaint(id, if_coped);
    }
}
