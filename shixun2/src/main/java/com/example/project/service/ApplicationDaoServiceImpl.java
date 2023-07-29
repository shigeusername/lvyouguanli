package com.example.project.service;


import com.example.project.dao.ApplicationDao;
import com.example.project.entity.Application;
import com.example.project.entity.VO.ApplicationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationDaoServiceImpl")
public class ApplicationDaoServiceImpl implements ApplicationDaoService{
    @Autowired
    ApplicationDao applicationDao;

    //用户提交申请表
    @Override
    public int addApplication(Application application) {
        return applicationDao.addApplication(application);
    }


    //用户是否提交过申请
    @Override
    public boolean ifSubmittedApplication(int user_id) {
        return applicationDao.ifSubmittedApplication(user_id);
    }

    //根据user的id查找申请表
    @Override
    public ApplicationVO findApplicationByUserId(int user_id) {
        return applicationDao.findApplicationByUserId(user_id);
    }

    //修改申请表（用户端）
    @Override
    public int updateApplication(Application application) {
        return applicationDao.updateApplication(application);
    }

    //查询所有申请表（管理员端）
    @Override
    public List<ApplicationVO> findAllApplication() {
        return applicationDao.findAllApplication();
    }

    //根据申请表的id查找申请表（管理端）
    @Override
    public ApplicationVO findApplicationById(int id) {
        return applicationDao.findApplicationById(id);
    }

    //审批申请表
    @Override
    public int reviewApplication(int id, String if_succeed) {
        return applicationDao.reviewApplication(id,if_succeed);
    }

    //根据id删除申请表
    @Override
    public int deleteApplicationById(int id){return applicationDao.deleteApplicationById(id);}

    //根据if_succeed筛选申请表
    @Override
    public List<ApplicationVO> selectApplicationByIf_succeed(String if_succeed){return applicationDao.selectApplicationByIf_succeed(if_succeed);}
}
