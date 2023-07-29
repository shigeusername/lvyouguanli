package com.example.project.service;


import com.example.project.dao.RescueVehicleDao;
import com.example.project.entity.RescueVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("RescueVehicleDaoServiceImpl")
public class RescueVehicleDaoServiceImpl implements RescueVehicleDaoService {
    @Autowired
    RescueVehicleDao rescueVehicleDao;

    @Override
    public int add(RescueVehicle rescueVehicle) {
        return rescueVehicleDao.add(rescueVehicle);
    }

    @Override
    public int delete(int id) {
        return rescueVehicleDao.delete(id);
    }

    @Override
    public int update(RescueVehicle rescueVehicle) {
        return rescueVehicleDao.update(rescueVehicle);
    }

    @Override
    public RescueVehicle findRescueVehicleByLicenseNumber(String license_number) {
        return rescueVehicleDao.findRescueVehicleByLicenseNumber(license_number);
    }

    @Override
    public int findTotalNumber() {
        return rescueVehicleDao.findTotalNumber();
    }

    @Override
    public List<RescueVehicle> findAll(int index, int pagesize) {
        index=(index-1)*pagesize;
        return rescueVehicleDao.findAll(index,pagesize);
    }

    @Override
    public RescueVehicle findRescueVehicleById(int id) {
        return rescueVehicleDao.findRescueVehicleById(id);
    }

    @Override
    public List<RescueVehicle> findRescueVehicleByAffiliatedEnterprise(int affiliated_enterprise) {
        return rescueVehicleDao.findRescueVehicleByAffiliatedEnterprise(affiliated_enterprise);
    }
}
