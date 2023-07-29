package com.example.project.service;

import com.example.project.dao.GuideDao;
import com.example.project.entity.Guide;
import com.example.project.entity.VO.GuideVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GuideDaoServiceImpl")
public class GuideDaoServiceImpl implements GuideDaoService{
    @Autowired
    GuideDao guideDao;

    //管理员通过申请表，添加新导游
    @Override
    public int addGuide(Guide guide){return guideDao.addGuide(guide);}

    //查询所有导游（管理员端）
    @Override
    public List<GuideVO> findAllGuide(){return guideDao.findAllGuide();}

    //根据id查找导游（管理员端）
    @Override
    public GuideVO findGuideById(int id){return guideDao.findGuideById(id);}

    //根据id删除导游（管理员端）
    @Override
    public int deleteGuideById(int id){return guideDao.deleteGuideById(id);}

    //根据id修改导游信息（管理员端）
    @Override
    public int updateGuideById(Guide guide){return guideDao.updateGuideById(guide);}

    //模糊查询导游（管理员端）
    @Override
    public List<GuideVO> findGuideVaguely(String s){return guideDao.findGuideVaguely(s);}

    //导游申领行程单（导游端）
    @Override
    public int guideApplyItinerary(int id,int itinerary_id){return guideDao.guideApplyItinerary(id,itinerary_id);}

    //根据旅行社id查找导游
    @Override
    public List<GuideVO> findGuideByAgency_id(int agency_id){return guideDao.findGuideByAgency_id(agency_id);}
}
