package com.example.project.dao;

import com.example.project.entity.Complaint;
import com.example.project.entity.VO.ComplaintVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ComplaintDao {
    List<ComplaintVO> findAllComplaint();

    ComplaintVO findComplaintById(int id);

    List<ComplaintVO> findComplaintBySender(int sender);

    List<ComplaintVO> findComplaintByEnterprise(int enterprise_id);

    List<ComplaintVO> findComplaintByLevel(int level);

    List<ComplaintVO> findComplaintUnCoped();

    List<ComplaintVO> findComplaintCoped();

    int AddComplaint(Complaint complaint);

    int DeleteComplaintById(int id);

    int DeleteComplaintCoped();

    int UpdateComplaint(Complaint complaint);

    int ReviewComplaint(int id, String if_coped);
}
