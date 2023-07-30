package com.example.project.dao;


import com.example.project.entity.Itinerary;
import com.example.project.entity.Tour_group;
import com.example.project.entity.User;
import com.example.project.entity.VO.Sinformation;
import com.example.project.entity.VO.Tguide;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ItineraryDao {

    //查看所有旅行团点的信息
    List<Itinerary> findall(String i_name, int price_up, int price_down);

    //根据id查旅行社名称
    //或者根据景区id查景区名称
    String findJById(int id);

    //根据行程单id查行程单详情
    Itinerary findXjById(int id);

    //根据行程单id查行程单人数
    int countTGById(int id);

    //根据行程单id查导游名称
    String findGNById(int id);

    //查看我的预约
    int reverseTG(int t_id, int u_id);

    //根据行程单id获取我的全部预约
    List<Tour_group> getMyReverse(int id);

    //通过行程单id删除记录
    int deleteTGByUIII(int u_id, int i_id);

    //通过导游id查导游信息
    Tguide getGuideById(int id);

    //通过景区id找景区名和img
    Sinformation findTNameImgById(int id);

    //通过导游id查团成员信息
    List<User> findUserByGid(int id);

    //查找导游能预定的所有行程单
    List<Itinerary>findAllGuide();

    //更新导游行程单信息
    int updateGIIdById(int i_id, int g_id);
}
