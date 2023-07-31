package com.example.project.controller;


import com.example.project.common.ResultUtil;
import com.example.project.entity.Administrator;
import com.example.project.entity.TourismEnterprise;
import com.example.project.service.AdministratorDaoService;
import com.example.project.service.TourismEnterpriseDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@Api
public class AdministratorController {
    @Autowired
    AdministratorDaoService administratorDaoService;

    @Autowired
    TourismEnterpriseDaoService tourismEnterpriseDaoService;

    @PostMapping(value = "addAdministrator")
    @ApiOperation("新增Administrator数据")
        //新增数据
    ResultUtil<Integer> add(@RequestBody HashMap<String, String> map) {
        String affiliated_enterprise =map.get("affiliated_enterprise");
        String name = map.get("name");
        String age = map.get("age");
        String gender = map.get("gender");
        String position = map.get("position");
        if(affiliated_enterprise.isEmpty()||name.isEmpty()||age.isEmpty()||gender.isEmpty()||position.isEmpty())
            return ResultUtil.fail();//各项数据不能为空

        int affiliated_enterpriseid;
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise);
        if(tourismEnterprise!=null)
            affiliated_enterpriseid=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise).getId();
        else return ResultUtil.fail(7000,"添加信息中的所属企业不存在");
        int iage=Integer.parseInt(age);
        Administrator administrator = new Administrator(affiliated_enterpriseid, name, iage,gender,position);
        return ResultUtil.success(administratorDaoService.add(administrator));//成功返回1
    }

    @DeleteMapping(value = "deleteAdministrator")
    @ApiOperation("删除Administrator数据")
        //删除数据
    ResultUtil<Integer> delete(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(administratorDaoService.delete(id));
    }

    @PutMapping(value = "updateAdministrator")
    @ApiOperation("更新Administrator数据")
        //更新数据
    ResultUtil<Integer> update(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String affiliated_enterprise = map.get("affiliated_enterprise");
        int affiliated_enterpriseid;
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise);
        String name = map.get("name");
        String sage = map.get("age");
        int age=Integer.parseInt(sage);
        String gender = map.get("gender");
        String position = map.get("position");
        Administrator administrator=administratorDaoService.findAdministratorById(id);

        if(affiliated_enterprise.isEmpty()||name.isEmpty()||sage.isEmpty()||gender.isEmpty()||position.isEmpty())
            return ResultUtil.fail();//各项数据不能为空
        if(tourismEnterprise!=null)
            affiliated_enterpriseid=tourismEnterpriseDaoService.findTourismEnterpriseByName(affiliated_enterprise).getId();
        else return ResultUtil.fail(7000,"更新信息中的所属企业不存在");

        if(tourismEnterpriseDaoService.findTourismEnterpriseById(administrator.getAffiliated_enterprise()).getName().equals(affiliated_enterprise)&&administrator.getName().equals(name)&&administrator.getAge()==age&&administrator.getGender().equals(gender)&&administrator.getPosition().equals(position))
            return ResultUtil.fail(6000,"前后信息不变");//前后信息不变

        administrator.setAffiliated_enterprise(affiliated_enterpriseid);
        administrator.setName(name);
        administrator.setAge(age);
        administrator.setGender(gender);
        administrator.setPosition(position);
        return  ResultUtil.success(administratorDaoService.update(administrator));
    }

    @PostMapping (value = "findAdministratorByName")
    @ResponseBody
    @ApiOperation("根据name查找Administrator")
        //name查找
    Object findAdministratorByLicenseNumber(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        List<Administrator> administrator=administratorDaoService.findAdministratorByName(name);
        if(!administrator.isEmpty())
            return  ResultUtil.success(administrator);
        else return ResultUtil.fail();
    }

    @PostMapping (value = "findAdministratorById")
    @ResponseBody
    @ApiOperation("根据id查找Administrator")
        //id查找
    ResultUtil<Administrator> findAdministratorById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(administratorDaoService.findAdministratorById(id));
    }

    @GetMapping (value = "findAdministratorTotalNumber")
    @ApiOperation("查找所有Administrator的数量")
    ResultUtil<Integer> findTotalNumber(){
        return ResultUtil.success(administratorDaoService.findTotalNumber());
    }

    @PostMapping (value = "findAllAdministrator")
    @ResponseBody
    @ApiOperation("查找对应页数的Administrator")
    Object findAll(@RequestBody HashMap<String, String> map) {
        int index = Integer.parseInt(map.get("index"));
        int pagesize = Integer.parseInt(map.get("pagesize"));
        List<Administrator> administrator=administratorDaoService.findAll(index,pagesize);
        if(!administrator.isEmpty())
            return ResultUtil.success(administrator);
        else return  ResultUtil.fail();
    }

    @PostMapping (value = "findAdministratorByAffiliatedEnterprise")
    @ResponseBody
    @ApiOperation("根据affiliated_enterprise查找与该企业相关的管理人员")
        //id查找
    Object findAdministratorByAffiliatedEnterprise(@RequestBody HashMap<String, String> map) {
        int affiliated_enterprise = Integer.parseInt(map.get("affiliated_enterprise"));
        List<Administrator> administrators=administratorDaoService.findAdministratorByAffiliatedEnterprise(affiliated_enterprise);
        if (!administrators.isEmpty())
            return ResultUtil.success(administrators);
        else return ResultUtil.fail();
    }
}

