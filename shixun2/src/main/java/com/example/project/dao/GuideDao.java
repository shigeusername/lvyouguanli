package com.example.project.dao;

import com.example.project.entity.Application;
import com.example.project.entity.Guide;
import com.example.project.entity.VO.GuideVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GuideDao {
    //管理员通过申请表，添加新导游
    int addGuide(Guide guide);

    //查询所有导游（管理员端）
    List<GuideVO> findAllGuide(int pageNum,int pageSize);

    //根据id查找导游（管理员端）
    GuideVO findGuideById(int id);

    //根据id删除导游
    int deleteGuideById(int id);

    //根据id修改导游信息
    int updateGuideById(Guide guide);

    //模糊查询导游（管理员端）
    List<GuideVO> findGuideVaguely(String s);

    //导游申领行程单（导游端）
    int guideApplyItinerary(int id,int itinerary_id);

    //根据旅行社id查找导游
    List<GuideVO> findGuideByAgency_id(int agency_id,int pageNum,int pageSize);

    //查询所有导游的数量
    int findNumOfAllGuide();

    //查询根据旅行社id查找导游的数量
   int findNumOfGuideByAgency_id(int agency_id);
}
