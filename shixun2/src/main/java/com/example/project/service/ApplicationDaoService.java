package com.example.project.service;

import com.example.project.entity.Application;
import com.example.project.entity.VO.ApplicationVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationDaoService {
    //用户提交申请表
    int addApplication(Application application);

    //用户是否提交过申请
    boolean ifSubmittedApplication(int user_id);

    //根据user的id查找申请表
    ApplicationVO findApplicationByUserId (int user_id);

    //修改申请表（用户端）
    int updateApplication(Application application);



    //查询所有申请表（管理员端）
    List<ApplicationVO> findAllApplication(int pageNum,int pageSize);

    //根据申请表的id查找申请表（管理端）
    ApplicationVO findApplicationById (int id);

    //审批申请表
    int reviewApplication(int id,String if_succeed);

    //根据id删除申请表
    int deleteApplicationById(int id);

    //根据if_succeed筛选申请表
    List<ApplicationVO> selectApplicationByIf_succeed(String if_succeed,int pageNum,int pageSize);

    //查询所有申请表的数量
    int findNumOfAllApplication();

    //查询if_succeed=？的申请表的数量
    int findNumOfApplicationByIf_succeed(String if_succeed);
}
