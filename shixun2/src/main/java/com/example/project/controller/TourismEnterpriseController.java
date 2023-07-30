package com.example.project.controller;


import com.example.project.common.ResultUtil;
import com.example.project.entity.TourismEnterprise;
import com.example.project.entity.VO.ConciseTourismEnterprise;
import com.example.project.service.TourismEnterpriseDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Api
public class TourismEnterpriseController {
    @Autowired
    TourismEnterpriseDaoService tourismEnterpriseDaoService;

    @PostMapping(value = "addAttractions")
    @ApiOperation("新增Attractions数据")
        //新增数据
    ResultUtil<Integer> addAttractions(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        String capacity = map.get("capacity");
        String parking_space = map.get("parking_space");
        String current_people = map.get("current_people");
        String current_parking = map.get("current_parking");
        String location = map.get("location");
        String credit = map.get("credit");
        String img = map.get("img");
        String introduction = map.get("introduction");
        String star = map.get("star");
        String latitude = map.get("latitude");
        String longitude = map.get("longitude");
        if(name.isEmpty() || capacity.isEmpty() || parking_space.isEmpty() || current_people.isEmpty() || current_parking.isEmpty() || location.isEmpty() || credit.isEmpty() || img.isEmpty() || introduction.isEmpty() || star.isEmpty() || latitude.isEmpty() || longitude.isEmpty())
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if (tourismEnterprise!=null)
            return ResultUtil.fail(7000,"添加信息中的企业已经存在");

        int icapacity=Integer.parseInt(capacity);
        int iparking_space=Integer.parseInt(parking_space);
        int icurrent_people=Integer.parseInt(current_people);
        int icurrent_parking=Integer.parseInt(current_parking);
        double icredit=Double.parseDouble(credit);
        int istar=Integer.parseInt(star);
        double dlatitude=Double.parseDouble(latitude);
        double dlongitude=Double.parseDouble(longitude);
        TourismEnterprise newtourismEnterprise=new TourismEnterprise(name,"1",icapacity,iparking_space,icurrent_people,icurrent_parking,location,icredit,img,introduction,istar,dlatitude,dlongitude);
        return ResultUtil.success(tourismEnterpriseDaoService.addTourismEnterprise(newtourismEnterprise));//成功返回1
    }

    @PostMapping(value = "addHotels")
    @ApiOperation("新增Hotels数据")
        //新增数据
    ResultUtil<Integer> addHotels(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        String capacity = map.get("capacity");
        String parking_space = map.get("parking_space");
        String current_people = map.get("current_people");
        String current_parking = map.get("current_parking");
        String location = map.get("location");
        String credit = map.get("credit");
        String img = map.get("img");
        String introduction = map.get("introduction");
        String star = map.get("star");
        String latitude = map.get("latitude");
        String longitude = map.get("longitude");
        if(name.isEmpty() || capacity.isEmpty() || parking_space.isEmpty() || current_people.isEmpty() || current_parking.isEmpty() || location.isEmpty() || credit.isEmpty() || img.isEmpty() || introduction.isEmpty() || star.isEmpty() || latitude.isEmpty() || longitude.isEmpty())
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if (tourismEnterprise!=null)
            return ResultUtil.fail(7000,"添加信息中的企业已经存在");

        int icapacity=Integer.parseInt(capacity);
        int iparking_space=Integer.parseInt(parking_space);
        int icurrent_people=Integer.parseInt(current_people);
        int icurrent_parking=Integer.parseInt(current_parking);
        double icredit=Double.parseDouble(credit);
        int istar=Integer.parseInt(star);
        double dlatitude=Double.parseDouble(latitude);
        double dlongitude=Double.parseDouble(longitude);
        TourismEnterprise newtourismEnterprise=new TourismEnterprise(name,"2",icapacity,iparking_space,icurrent_people,icurrent_parking,location,icredit,img,introduction,istar,dlatitude,dlongitude);
        return ResultUtil.success(tourismEnterpriseDaoService.addTourismEnterprise(newtourismEnterprise));//成功返回1
    }
    @PostMapping(value = "addAgency")
    @ApiOperation("新增Agency数据")
        //新增数据
    ResultUtil<Integer> addAgency(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        String capacity = map.get("capacity");
        String parking_space = map.get("parking_space");
        String current_people = map.get("current_people");
        String current_parking = map.get("current_parking");
        String location = map.get("location");
        String credit = map.get("credit");
        String img = map.get("img");
        String introduction = map.get("introduction");
        String star = map.get("star");
        String latitude = map.get("latitude");
        String longitude = map.get("longitude");
        if(name.isEmpty() || capacity.isEmpty() || parking_space.isEmpty() || current_people.isEmpty() || current_parking.isEmpty() || location.isEmpty() || credit.isEmpty() || img.isEmpty() || introduction.isEmpty() || star.isEmpty() || latitude.isEmpty() || longitude.isEmpty())
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if (tourismEnterprise!=null)
            return ResultUtil.fail(7000,"添加信息中的企业已经存在");

        int icapacity=Integer.parseInt(capacity);
        int iparking_space=Integer.parseInt(parking_space);
        int icurrent_people=Integer.parseInt(current_people);
        int icurrent_parking=Integer.parseInt(current_parking);
        double icredit=Double.parseDouble(credit);
        int istar=Integer.parseInt(star);
        double dlatitude=Double.parseDouble(latitude);
        double dlongitude=Double.parseDouble(longitude);
        TourismEnterprise newtourismEnterprise=new TourismEnterprise(name,"3",icapacity,iparking_space,icurrent_people,icurrent_parking,location,icredit,img,introduction,istar,dlatitude,dlongitude);
        return ResultUtil.success(tourismEnterpriseDaoService.addTourismEnterprise(newtourismEnterprise));//成功返回1
    }

    @DeleteMapping(value = "deleteTourismEnterprise")
    @ApiOperation("删除TourismEnterprise数据")
        //删除数据
    ResultUtil<Integer> delete(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(tourismEnterpriseDaoService.delete(id));
    }

    @PutMapping(value = "updateTourismEnterprise")
    @ApiOperation("更新TourismEnterprise数据")
        //更新数据
    ResultUtil<Integer> update(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String name = map.get("name");
        String scapacity = map.get("capacity");
        int capacity=Integer.parseInt(scapacity);
        String sparking_space = map.get("parking_space");
        int parking_space=Integer.parseInt(scapacity);
        String scurrent_people = map.get("current_people");
        int current_people=Integer.parseInt(scurrent_people);
        String scurrent_parking = map.get("current_parking");
        int current_parking=Integer.parseInt(scurrent_parking);
        String location = map.get("location");
        String scredit =map.get("credit");
        double credit=Double.parseDouble(scredit);
        String img = map.get("img");
        String introduction = map.get("introduction");
        String sstar = map.get("star");
        int star=Integer.parseInt(sstar);
        String slatitude = map.get("latitude");
        double latitude = Double.parseDouble(slatitude);
        String slongitude = map.get("longitude");
        double longitude = Double.parseDouble(slongitude);
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseById(id);
        if(name.isEmpty() || scapacity.isEmpty() || sparking_space.isEmpty() || scurrent_people.isEmpty() || scurrent_parking.isEmpty() || location.isEmpty() || scredit.isEmpty() || img.isEmpty() || introduction.isEmpty() || sstar.isEmpty() || slatitude.isEmpty() || slongitude.isEmpty())
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        if(tourismEnterprise.getName().equals(name)&&tourismEnterprise.getCapacity()==capacity&&tourismEnterprise.getParking_space()==parking_space&&tourismEnterprise.getCurrent_people()==current_people&&tourismEnterprise.getCurrent_parking()==current_parking&&tourismEnterprise.getLocation().equals(location)&&tourismEnterprise.getCredit()==credit&&tourismEnterprise.getImg().equals(img)&&tourismEnterprise.getIntroduction().equals(introduction)&&tourismEnterprise.getStar()==star&&tourismEnterprise.getLatitude()==latitude&&tourismEnterprise.getLongitude()==longitude)
            return ResultUtil.fail(6000,"前后信息不变");//前后信息不变
        if(!tourismEnterprise.getName().equals(name)&&tourismEnterpriseDaoService.findTourismEnterpriseByName(name)!=null)
            return ResultUtil.fail(7000,"更改信息中的企业已经存在");

        tourismEnterprise.setName(name);
        tourismEnterprise.setCapacity(capacity);
        tourismEnterprise.setParking_space(parking_space);
        tourismEnterprise.setCurrent_people(current_people);
        tourismEnterprise.setCurrent_parking(current_parking);
        tourismEnterprise.setLocation(location);
        tourismEnterprise.setCredit(credit);
        tourismEnterprise.setImg(img);
        tourismEnterprise.setIntroduction(introduction);
        tourismEnterprise.setStar(star);
        tourismEnterprise.setLatitude(latitude);
        tourismEnterprise.setLongitude(longitude);
        return ResultUtil.success(tourismEnterpriseDaoService.update(tourismEnterprise));
    }

    @GetMapping (value = "findTourismEnterpriseByName")
    @ResponseBody
    @ApiOperation("根据name查找TourismEnterprise")
        //name查找
    Object findTourismEnterpriseByName(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        TourismEnterprise tourismEnterprises=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if(tourismEnterprises!=null)
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }
    @GetMapping (value = "findTotalNumberOfAttractions")
    @ApiOperation("查找所有Attractions的数量")
    ResultUtil<Integer> findTotalNumberOfAttractions(){
        return ResultUtil.success(tourismEnterpriseDaoService.findTotalNumberOfAttractions());
    }

    @GetMapping (value = "findTotalNumberOfHotels")
    @ApiOperation("查找所有Hotels的数量")
    ResultUtil<Integer> findTotalNumberOfHotels(){
        return ResultUtil.success(tourismEnterpriseDaoService.findTotalNumberOfHotels());
    }

    @GetMapping (value = "findTotalNumberOfAgency")
    @ApiOperation("查找所有Agency的数量")
    ResultUtil<Integer> findTotalNumberOfAgency(){
        return ResultUtil.success(tourismEnterpriseDaoService.findTotalNumberOfAgency());
    }

    @GetMapping (value = "findPageAttractions")
    @ResponseBody
    @ApiOperation("查找对应页数的Attractions")
    Object findPageAttractions(@RequestBody HashMap<String, String> map) {
        int index = Integer.parseInt(map.get("index"));
        int pagesize = Integer.parseInt(map.get("pagesize"));
        List<TourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findPageAttractions(index,pagesize);
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findPageHotels")
    @ResponseBody
    @ApiOperation("查找对应页数的Hotels")
    Object findPageHotels(@RequestBody HashMap<String, String> map) {
        int index = Integer.parseInt(map.get("index"));
        int pagesize = Integer.parseInt(map.get("pagesize"));
        List<TourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findPageHotels(index,pagesize);
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findPageAgency")
    @ResponseBody
    @ApiOperation("查找对应页数的Agency")
    Object findPageAgency(@RequestBody HashMap<String, String> map) {
        int index = Integer.parseInt(map.get("index"));
        int pagesize = Integer.parseInt(map.get("pagesize"));
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findPageAgency(index,pagesize);
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findThreeAttractions")
    @ResponseBody
    @ApiOperation("查找首页三个Attractions")
    Object findThreeAttractions() {
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findThreeAttractions();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findThreeHotels")
    @ResponseBody
    @ApiOperation("查找首页三个Hotels")
    Object findThreeHotels() {
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findThreeHotels();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findThreeAgency")
    @ResponseBody
    @ApiOperation("查找首页三个Agency")
    Object findThreeAgency() {
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findThreeAgency();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findAllAttractions")
    @ResponseBody
    @ApiOperation("查找所有Attractions（更多页面）")
    Object findAllAttractions() {
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findAllAttractions();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findAllHotels")
    @ResponseBody
    @ApiOperation("查找所有Hotels（更多页面）")
    Object findAllHotels() {
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findAllHotels();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findAllAgency")
    @ResponseBody
    @ApiOperation("查找所有Agency（更多页面）")
    Object findAllAgency() {
        List<ConciseTourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findAllAgency();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findTourismEnterpriseById")
    @ResponseBody
    @ApiOperation("根据id查找TourismEnterprise")
        //id查找
    ResultUtil<TourismEnterprise> findTourismEnterpriseById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return ResultUtil.success(tourismEnterpriseDaoService.findTourismEnterpriseById(id));
    }




}

