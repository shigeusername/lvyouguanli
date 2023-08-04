package com.example.project.service;

import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplaintDaoService {
    List<ComplaintVO> findAllComplaint(int pageNum, int pageSize);

    ComplaintVO findComplaintById(int id);

    List<ComplaintVO> findComplaintUnCoped(int pageNum, int pageSize);

    List<ComplaintVO> findComplaintCoped(int pageNum, int pageSize);

    //查询所有投诉的数量
    int findNumOfAllComplaint();

    //查询所有未处理的数量
    int findNumOfComplaintUnCoped();

    //查询所有已处理投诉的数量
    int findNumOfComplaintCoped();

    int AddComplaint(Complaint complain);

    int DeleteComplaintById(int id);

    int DeleteComplaintCoped();

    int UpdateComplaint(Complaint complaint);

    int ReviewComplaint(int id, String if_coped);
}
