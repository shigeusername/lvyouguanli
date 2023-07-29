package com.example.project.service;

import com.example.project.entity.VO.WarningVO;
import com.example.project.entity.Warning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("WarningDaoServiceImpl")
public class WarningDaoServiceImpl implements WarningDaoService{
    @Autowired
    WarningDaoService warningDaoService;
    @Override
    public List<WarningVO> findAllWarning() {
        return warningDaoService.findAllWarning();
    }

    @Override
    public WarningVO findWarningById(int id) {
        return warningDaoService.findWarningById(id);
    }

    @Override
    public List<WarningVO> findAllWarningNeedCope() {
        return warningDaoService.findAllWarningNeedCope();
    }

    @Override
    public List<WarningVO> findAllWarningNoRequired() {
        return warningDaoService.findAllWarningNoRequired();
    }

    @Override
    public List<WarningVO> findAllWarningCoping() {
        return warningDaoService.findAllWarningCoping();
    }

    @Override
    public List<WarningVO> findAllWarningDone() {
        return warningDaoService.findAllWarningDone();
    }

    @Override
    public int AddWarning(Warning warning) {
        return warningDaoService.AddWarning(warning);
    }

    @Override
    public int DeleteWarningById(int id) {
        return warningDaoService.DeleteWarningById(id);
    }

    @Override
    public int DeleteWarningCoped() {
        return warningDaoService.DeleteWarningCoped();
    }

    @Override
    public int UpdateWarning(Warning warning) {
        return warningDaoService.UpdateWarning(warning);
    }
}
