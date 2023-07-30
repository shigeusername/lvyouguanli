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
    public List<WarningVO> findAllWarning() {
        return warningDao.findAllWarning();
    }

    @Override
    public WarningVO findWarningById(int id) {
        return warningDao.findWarningById(id);
    }

    @Override
    public List<WarningVO> findAllWarningNeedCope() {
        return warningDao.findAllWarningNeedCope();
    }

    @Override
    public List<WarningVO> findAllWarningNoRequired() {
        return warningDao.findAllWarningNoRequired();
    }

    @Override
    public List<WarningVO> findAllWarningCoping() {
        return warningDao.findAllWarningCoping();
    }

    @Override
    public List<WarningVO> findAllWarningDone() {
        return warningDao.findAllWarningDone();
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
}
