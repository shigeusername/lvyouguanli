package com.example.project.dao;

import com.example.project.entity.VO.WarningVO;
import com.example.project.entity.Warning;

import java.util.List;

public interface WarningDao {
    List<WarningVO> findAllWarning();

    WarningVO findWarningById(int id);

    List<WarningVO> findAllWarningNeedCope();

    List<WarningVO> findAllWarningNoRequired();

    List<WarningVO> findAllWarningCoping();

    List<WarningVO> findAllWarningDone();

    int AddWarning(Warning Warning);

    int DeleteWarningById(int id);

    int DeleteWarningCoped();

    int UpdateWarning(Warning warning);
}
