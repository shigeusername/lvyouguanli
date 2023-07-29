package com.example.project.service;

import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ComplaintDaoService {
    List<ComplaintVO> findAllComplaint();

    ComplaintVO findComplaintById(int id);

    List<ComplaintVO> findComplaintBySender(int sender);

    List<ComplaintVO> findComplaintByEnterprise(int enterprise_id);

    List<ComplaintVO> findComplaintByLevel(int level);

    List<ComplaintVO> findComplaintUnCoped();

    List<ComplaintVO> findComplaintCoped();

    int AddComplaint(Complaint complain);

    int DeleteComplaintById(int id);

    int DeleteComplaintCoped();

    int UpdateComplaint(Complaint complaint);
}
