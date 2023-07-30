package com.example.project.service;


import com.example.project.dao.ItineraryDao;
import com.example.project.entity.Itinerary;
import com.example.project.entity.Tour_group;
import com.example.project.entity.User;
import com.example.project.entity.VO.Sinformation;
import com.example.project.entity.VO.Tguide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ItineraryDaoServicelmpl")
public class ItineraryDaoServicelmpl implements ItineraryDaoService{
    @Autowired
    ItineraryDao itineraryDao;


    @Override
    public List<Itinerary> findall(String i_name, int price_up, int price_down){
        return itineraryDao.findall(i_name,price_up,price_down);
    }

    @Override
    public String findjbyid(int id){
        return itineraryDao.findJById(id);
    }

    @Override
    public Itinerary findxjbyid(int id){
        return itineraryDao.findXjById(id);
    }

    @Override
    public int countTGById(int id) {
        return itineraryDao.countTGById(id);
    }

    @Override
    public String findGNById(int id){
        return itineraryDao.findGNById(id);
    }

    @Override
    public int reverseTG(int t_id, int u_id){
        return itineraryDao.reverseTG(t_id, u_id);
    }

    @Override
    public List<Tour_group> getMyReverse(int id){
        return itineraryDao.getMyReverse(id);
    }

    @Override
    public int deleteTGByUIII(int u_id, int i_id){
        return itineraryDao.deleteTGByUIII(u_id, i_id);
    }

    @Override
    public Tguide getGuideById(int id){
        return itineraryDao.getGuideById(id);
    }

    @Override
    public Sinformation findTNameImgById(int id){
        return itineraryDao.findTNameImgById(id);
    }

    @Override
    public List<User> findUserByGid(int id){
        return itineraryDao.findUserByGid(id);
    }

    @Override
    public List<Itinerary>findAllGuide(){
        return itineraryDao.findAllGuide();
    }

    @Override
    public int updateGIIdById(int i_id, int g_id){
        return itineraryDao.updateGIIdById(i_id,g_id);
    }
}
