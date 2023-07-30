package com.example.project.service;


import com.example.project.entity.Itinerary;
import com.example.project.entity.Tour_group;
import com.example.project.entity.User;
import com.example.project.entity.VO.Sinformation;
import com.example.project.entity.VO.Tguide;

import java.util.List;

public interface ItineraryDaoService {
    List<Itinerary> findall(String i_name, int price_up, int price_down);

    String findjbyid(int id);

    Itinerary findxjbyid(int id);

    int countTGById(int id);

    String findGNById(int id);

    int reverseTG(int t_id, int u_id);

    List<Tour_group> getMyReverse(int id);

    int deleteTGByUIII(int u_id, int i_id);

    Tguide getGuideById(int id);

    Sinformation findTNameImgById(int id);

    List<User> findUserByGid(int id);

    List<Itinerary>findAllGuide();

    int updateGIIdById(int i_id, int g_id);
}
