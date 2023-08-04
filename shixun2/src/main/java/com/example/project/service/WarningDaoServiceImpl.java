package com.example.project.service;

import com.example.project.dao.WarningDao;
import com.example.project.entity.VO.WarningVO;
import com.example.project.entity.Warning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("WarningDaoServiceImpl")
public class WarningDaoServiceImpl implements WarningDaoService{
    @Autowired
    WarningDao warningDao;

    @Override
    public List<WarningVO> findAllWarning(int pageNum, int pageSize) {
        return warningDao.findAllWarning(pageNum,pageSize);
    }

    @Override
    public WarningVO findWarningById(int id) {
        return warningDao.findWarningById(id);
    }

    @Override
    public List<WarningVO> findAllWarningNeedCope(int pageNum, int pageSize) {
        return warningDao.findAllWarningNeedCope(pageNum, pageSize);
    }

    @Override
    public List<WarningVO> findAllWarningNoRequired(int pageNum, int pageSize) {
        return warningDao.findAllWarningNoRequired(pageNum, pageSize);
    }

    @Override
    public List<WarningVO> findAllWarningCoping(int pageNum, int pageSize) {
        return findAllWarningCoping(pageNum, pageSize);
    }

    @Override
    public List<WarningVO> findAllWarningDone(int pageNum, int pageSize) {
        return warningDao.findAllWarningDone(pageNum, pageSize);
    }

    @Override
    public int findNumOfAllWarning() {
        return warningDao.findNumOfAllWarning();
    }

    @Override
    public int findNumOfAllWarningNeedCope() {
        return warningDao.findNumOfAllWarningNeedCope();
    }

    @Override
    public int findNumOfAllWarningNoRequired() {
        return warningDao.findNumOfAllWarningNoRequired();
    }

    @Override
    public int findNumOfWarningCoping() {
        return warningDao.findNumOfWarningCoping();
    }

    @Override
    public int findNumOfAllWarningDone() {
        return warningDao.findNumOfAllWarningDone();
    }

    @Override
    public int AddWarning(Warning warning) {
        return warningDao.AddWarning(warning);
    }

    @Override
    public int DeleteWarningById(int id) {
        return warningDao.DeleteWarningById(id);
    }

    @Override
    public int DeleteWarningCoped() {
        return warningDao.DeleteWarningCoped();
    }

    @Override
    public int UpdateWarning(Warning warning) {
        return warningDao.UpdateWarning(warning);
    }

    @Override
    public int ReviewWarning(int id, String need_cope){
        return warningDao.ReviewWarning(id,need_cope);
    }
}
