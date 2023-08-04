package com.example.project.dao;

import com.example.project.entity.VO.WarningVO;
import com.example.project.entity.Warning;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WarningDao {
    List<WarningVO> findAllWarning(int pageNum, int pageSize);

    WarningVO findWarningById(int id);

    List<WarningVO> findAllWarningNeedCope(int pageNum, int pageSize);

    List<WarningVO> findAllWarningNoRequired(int pageNum, int pageSize);

    List<WarningVO> findAllWarningCoping(int pageNum, int pageSize);

    List<WarningVO> findAllWarningDone(int pageNum, int pageSize);

    //查询所有信息的数量
    int findNumOfAllWarning();

    //查询所有需审批信息的数量
    int findNumOfAllWarningNeedCope();

    //查询所有不需审批的数量
    int findNumOfAllWarningNoRequired();

    //查询所有正在处理投诉的数量
    int findNumOfWarningCoping();

    //查询所有已处理投诉的数量
    int findNumOfAllWarningDone();

    int AddWarning(Warning Warning);

    int DeleteWarningById(int id);

    int DeleteWarningCoped();

    int UpdateWarning(Warning warning);

    int ReviewWarning(int id, String need_cope);
}
