package com.example.project.controller;


import com.example.project.common.ResultUtil;
import com.example.project.entity.RescueVehicle;
import com.example.project.entity.TourismEnterprise;
import com.example.project.service.RescueVehicleDaoService;
import com.example.project.service.TourismEnterpriseDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Api
public class RescueVehicleController {
    @Autowired
    RescueVehicleDaoService rescueVehicleDaoService;
    @Autowired
    TourismEnterpriseDaoService tourismEnterpriseDaoService;

    @PostMapping(value = "addRescueVehicle")
    @ApiOperation("新增RescueVehicle数据")
        //新增数据
    ResultUtil<Integer> add(@RequestBody HashMap<String, String> map) {
        String license_number = map.get("license_number");
        String driver_name = map.get("driver_name");
        String driver_age = map.get("driver_age");
        String phone = map.get("phone");
        String affiliated_enterprise =map.get("affiliated_enterprise");
        String driver_gender = map.get("driver_gender");
        if(rescueVehicleDaoService.findRescueVehicleByLicenseNumber(license_number)!=null)
            return ResultUtil.fail(6000,"该救援车辆"+license_number+"已经存在");
        if(license_number.isEmpty()||driver_name.isEmpty()||driver_age.isEmpty()||phone.isEmpty()||affiliated_enterprise.isEmpty()||driver_gender.isEmpty())
            return ResultUtil.fail();//各项数据不能为空，否则返回0


        int driverage=Integer.parseInt(driver_age);
        int affiliated_enterpriseid;
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise);
        if(tourismEnterprise!=null)
            affiliated_enterpriseid=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise).getId();
        else return ResultUtil.fail(7000,"添加信息中的所属企业不存在");
        RescueVehicle rescueVehicle = new RescueVehicle(license_number, driver_name, driverage,phone,affiliated_enterpriseid,driver_gender);
        return ResultUtil.success(rescueVehicleDaoService.add(rescueVehicle));//成功返回1
    }

    @DeleteMapping(value = "deleteRescueVehicle")
    @ApiOperation("删除RescueVehicle数据")
        //删除数据
    ResultUtil<Integer> delete(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(rescueVehicleDaoService.delete(id));
    }

    @PutMapping(value = "updateRescueVehicle")
    @ApiOperation("更新RescueVehicle数据")
        //更新数据
    ResultUtil<Integer> update(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String license_number = map.get("license_number");
        String driver_name = map.get("driver_name");
        String driver_age = map.get("driver_age");
        int idriver_age=Integer.parseInt(driver_age);
        String phone = map.get("phone");
        String affiliated_enterprise = map.get("affiliated_enterprise");
        int affiliated_enterpriseid;
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise);

        String driver_gender = map.get("driver_gender");
        RescueVehicle rescueVehicle=rescueVehicleDaoService.findRescueVehicleById(id);
        if(license_number.isEmpty()||driver_name.isEmpty()||driver_age.isEmpty()||phone.isEmpty()||affiliated_enterprise.isEmpty()||driver_gender.isEmpty())
            return ResultUtil.fail();//各项数据不能为空

        if(tourismEnterprise!=null)
            affiliated_enterpriseid=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise).getId();
        else return ResultUtil.fail(7000,"更新信息中的所属企业不存在");

        if(rescueVehicle.getLicense_number().equals(license_number)&&rescueVehicle.getDriver_name().equals(driver_name)&&rescueVehicle.getDriver_age()==idriver_age&&rescueVehicle.getPhone().equals(phone)&&rescueVehicle.getAffiliated_enterprise()==affiliated_enterpriseid&&rescueVehicle.getDriver_gender().equals(driver_gender))
            return ResultUtil.fail(6000,"前后信息不变");//前后信息不变


        if(rescueVehicleDaoService.findRescueVehicleByLicenseNumber(license_number)!=null&&rescueVehicle.getLicense_number()!=license_number)
            return ResultUtil.fail(8000,"该救援车辆"+license_number+"已经存在");


        rescueVehicle.setLicense_number(license_number);
        rescueVehicle.setDriver_name(driver_name);
        rescueVehicle.setDriver_age(idriver_age);
        rescueVehicle.setPhone(phone);
        rescueVehicle.setAffiliated_enterprise(affiliated_enterpriseid);
        rescueVehicle.setDriver_gender(driver_gender);
        return ResultUtil.success(rescueVehicleDaoService.update(rescueVehicle));
    }

    @PostMapping (value = "findRescueVehicleByLicenseNumber")
    @ResponseBody
    @ApiOperation("根据license_number查找RescueVehicle")
        //license_number查找
    Object findRescueVehicleByLicenseNumber(@RequestBody HashMap<String, String> map) {
        String license_number = map.get("license_number");
        RescueVehicle rescueVehicle=rescueVehicleDaoService.findRescueVehicleByLicenseNumber(license_number);
        if(rescueVehicle!=null)
            return ResultUtil.success(rescueVehicle);
        else return ResultUtil.fail();
    }

    @PostMapping (value = "findRescueVehicleById")
    @ResponseBody
    @ApiOperation("根据id查找RescueVehicle")
        //id查找
    ResultUtil<RescueVehicle> findRescueVehicleById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(rescueVehicleDaoService.findRescueVehicleById(id));
    }

    @GetMapping (value = "findRescueVehicleTotalNumber")
    @ApiOperation("查找所有RescueVehicle的数量")
    ResultUtil<Integer> findTotalNumber(){
        return ResultUtil.success(rescueVehicleDaoService.findTotalNumber());
    }

    @PostMapping (value = "findAllRescueVehicle")
    @ResponseBody
    @ApiOperation("查找对应页数的RescueVehicle")
    Object findAll(@RequestBody HashMap<String, String> map) {
        int index = Integer.parseInt(map.get("index"));
        int pagesize = Integer.parseInt(map.get("pagesize"));
        List<RescueVehicle> rescueVehicles=rescueVehicleDaoService.findAll(index,pagesize);
        if(!rescueVehicles.isEmpty())
            return ResultUtil.success(rescueVehicles);
        else return ResultUtil.fail();
    }

    @PostMapping (value = "findRescueVehicleByAffiliatedEnterprise")
    @ResponseBody
    @ApiOperation("根据affiliated_enterprise查找与该企业相关的救援车辆")
        //id查找
    Object findRescueVehicleByAffiliatedEnterprise(@RequestBody HashMap<String, String> map) {
        int affiliated_enterprise = Integer.parseInt(map.get("affiliated_enterprise"));
        List<RescueVehicle> rescueVehicles=rescueVehicleDaoService.findRescueVehicleByAffiliatedEnterprise(affiliated_enterprise);
        if (!rescueVehicles.isEmpty())
            return ResultUtil.success(rescueVehicles);
        else return ResultUtil.fail();
    }
}

