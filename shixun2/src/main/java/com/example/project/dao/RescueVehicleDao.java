package com.example.project.dao;

import com.example.project.entity.RescueVehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RescueVehicleDao {
    //新增数据
    int add(RescueVehicle rescueVehicle);

    //删除数据
    int delete(int id);

    //更新数据
    int update(RescueVehicle rescueVehicle);

    //根据license_number查找
    RescueVehicle findRescueVehicleByLicenseNumber(String license_number);

    //查找救援车辆的总数
    int findTotalNumber();

    //查找每一页的救援车辆信息
    List<RescueVehicle> findAll(int index,int pagesize);

    //根据id查找救援车辆
    RescueVehicle findRescueVehicleById(int id);

    //根据affiliated_enterprise查找与该企业相关的救援车辆
    List<RescueVehicle> findRescueVehicleByAffiliatedEnterprise(int affiliated_enterprise);
}
