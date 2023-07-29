package com.example.project.dao;

import com.example.project.entity.TourismEnterprise;
import com.example.project.entity.VO.ConciseTourismEnterprise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourismEnterpriseDao {
    //新增旅游景区数据
    int addTourismEnterprise(TourismEnterprise tourismEnterprise);
    /*//新增旅游景区数据
    int addAttractions(TourismEnterprise tourismEnterprise);
    //新增星级酒店数据
    int addHotels(TourismEnterprise tourismEnterprise);
    //新增旅行社数据
    int addAgency(TourismEnterprise tourismEnterprise);*/

    //删除数据
    int delete(int id);

    //更新数据
    int update(TourismEnterprise tourismEnterprise);

    //根据name查找
    TourismEnterprise findTourismEnterpriseByName(String name);

    //查找旅游景区的总数
    int findTotalNumberOfAttractions();
    //查找星级酒店的总数
    int findTotalNumberOfHotels();
    //查找旅行社的总数
    int findTotalNumberOfAgency();

    //查找管理页面每一页的旅游景区信息
    List<TourismEnterprise> findPageAttractions(int index, int pagesize);
    //查找管理页面每一页的星级酒店信息
    List<TourismEnterprise> findPageHotels(int index, int pagesize);
    //查找管理页面每一页的旅行社信息
    List<ConciseTourismEnterprise> findPageAgency(int index, int pagesize);

    //查找首页的旅游景区信息
    List<ConciseTourismEnterprise> findThreeAttractions();
    //查找首页的星级酒店信息
    List<ConciseTourismEnterprise> findThreeHotels();
    //查找首页的旅行社信息
    List<ConciseTourismEnterprise> findThreeAgency();

    //查找更多旅游景区信息
    List<ConciseTourismEnterprise> findAllAttractions();
    //查找更多星级酒店信息
    List<ConciseTourismEnterprise> findAllHotels();
    //查找更多旅行社信息
    List<ConciseTourismEnterprise> findAllAgency();

    //根据id查找单个旅游企业详情
    TourismEnterprise findTourismEnterpriseById(int id);
}
