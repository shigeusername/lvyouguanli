package com.example.project.dao;

import com.example.project.entity.Complaint;

import java.util.List;

public interface ComplaintDao {
    List<Complaint> findAllComplaint();

    Complaint findComplaintById();

    List<Complaint> findComplaintBySender(int sender);

    List<Complaint> findComplaintByEnterprise(int enterprise_id);

    List<Complaint> findComplaintByLevel(int level);

    List<Complaint> findComplaintUnCoped();

    int AddComplaint(Complaint complaint);

    int DeleteComplaintById(int id);

    int DeleteComplaintCoped();

    int UpdateComplaint(Complaint complaint);
}
