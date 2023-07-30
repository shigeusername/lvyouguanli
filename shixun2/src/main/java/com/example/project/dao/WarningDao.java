package com.example.project.dao;

import com.example.project.entity.VO.WarningVO;
import com.example.project.entity.Warning;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
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
