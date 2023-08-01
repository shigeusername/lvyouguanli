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
import java.util.Map;

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
        String introduction = map.get("introduction");
        String star = map.get("star");
        if(name.isEmpty() || capacity.isEmpty() || parking_space.isEmpty() || current_people.isEmpty() || current_parking.isEmpty() || location.isEmpty() ||  introduction.isEmpty() || star.isEmpty() )
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if (tourismEnterprise!=null)
            return ResultUtil.fail(7000,"添加信息中的企业已经存在");

        int icapacity=Integer.parseInt(capacity);
        int iparking_space=Integer.parseInt(parking_space);
        int icurrent_people=Integer.parseInt(current_people);
        int icurrent_parking=Integer.parseInt(current_parking);
        int istar=Integer.parseInt(star);
        TourismEnterprise newtourismEnterprise=new TourismEnterprise(name,"1",icapacity,iparking_space,icurrent_people,icurrent_parking,location,100.0,"https://youimg1.c-ctrip.com/target/10081f000001gqgew105A_D_10000_1200.jpg?proc=autoorient",introduction,istar,116.397128,39.916527);
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
        String introduction = map.get("introduction");
        String star = map.get("star");
        if(name.isEmpty() || capacity.isEmpty() || parking_space.isEmpty() || current_people.isEmpty() || current_parking.isEmpty() || location.isEmpty() ||  introduction.isEmpty() || star.isEmpty() )
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if (tourismEnterprise!=null)
            return ResultUtil.fail(7000,"添加信息中的企业已经存在");

        int icapacity=Integer.parseInt(capacity);
        int iparking_space=Integer.parseInt(parking_space);
        int icurrent_people=Integer.parseInt(current_people);
        int icurrent_parking=Integer.parseInt(current_parking);
        int istar=Integer.parseInt(star);
        TourismEnterprise newtourismEnterprise=new TourismEnterprise(name,"2",icapacity,iparking_space,icurrent_people,icurrent_parking,location,100.0,"https://youimg1.c-ctrip.com/target/10081f000001gqgew105A_D_10000_1200.jpg?proc=autoorient",introduction,istar,116.397128,39.916527);
        return ResultUtil.success(tourismEnterpriseDaoService.addTourismEnterprise(newtourismEnterprise));//成功返回1
    }
    @PostMapping(value = "addAgency")
    @ApiOperation("新增Agency数据")
        //新增数据
    ResultUtil<Integer> addAgency(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        String location = map.get("location");
        String introduction = map.get("introduction");
        String star = map.get("star");
        if(name.isEmpty()  || location.isEmpty() ||  introduction.isEmpty() || star.isEmpty() )
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseByName(name);
        if (tourismEnterprise!=null)
            return ResultUtil.fail(7000,"添加信息中的企业已经存在");

        int istar=Integer.parseInt(star);
        TourismEnterprise newtourismEnterprise=new TourismEnterprise(name,"3",5000,500,2500,250,location,100.0,"https://youimg1.c-ctrip.com/target/10081f000001gqgew105A_D_10000_1200.jpg?proc=autoorient",introduction,istar,116.397128,39.916527);
        return ResultUtil.success(tourismEnterpriseDaoService.addTourismEnterprise(newtourismEnterprise));//成功返回1
    }

    @DeleteMapping(value = "deleteTourismEnterprise/{id}")
    @ApiOperation("删除TourismEnterprise数据")
        //删除数据
    ResultUtil<Integer> delete(@PathVariable("id") int id) {
        return ResultUtil.success(tourismEnterpriseDaoService.delete(id));
    }

    @PutMapping(value = "updateAttractionsAndHotels")
    @ApiOperation("更新AttractionsAndHotels数据")
        //更新数据
    ResultUtil<Integer> updateAttractionsAndHotels(@RequestBody HashMap<String, String> map) {
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
        String introduction = map.get("introduction");
        String sstar = map.get("star");
        int star=Integer.parseInt(sstar);
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseById(id);
        if(name.isEmpty() || scapacity.isEmpty() || sparking_space.isEmpty() || scurrent_people.isEmpty() || scurrent_parking.isEmpty() || location.isEmpty() || introduction.isEmpty() || sstar.isEmpty() )
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        if(tourismEnterprise.getName().equals(name)&&tourismEnterprise.getCapacity()==capacity&&tourismEnterprise.getParking_space()==parking_space&&tourismEnterprise.getCurrent_people()==current_people&&tourismEnterprise.getCurrent_parking()==current_parking&&tourismEnterprise.getLocation().equals(location)&&tourismEnterprise.getIntroduction().equals(introduction)&&tourismEnterprise.getStar()==star)
            return ResultUtil.fail(6000,"前后信息不变");//前后信息不变
        if(!tourismEnterprise.getName().equals(name)&&tourismEnterpriseDaoService.findTourismEnterpriseByName(name)!=null)
            return ResultUtil.fail(7000,"更改信息中的企业已经存在");

        tourismEnterprise.setName(name);
        tourismEnterprise.setCapacity(capacity);
        tourismEnterprise.setParking_space(parking_space);
        tourismEnterprise.setCurrent_people(current_people);
        tourismEnterprise.setCurrent_parking(current_parking);
        tourismEnterprise.setLocation(location);
        tourismEnterprise.setIntroduction(introduction);
        tourismEnterprise.setStar(star);
        return ResultUtil.success(tourismEnterpriseDaoService.update(tourismEnterprise));
    }

    @PutMapping(value = "updateAgency")
    @ApiOperation("更新Agency数据")
        //更新数据
    ResultUtil<Integer> updateAgency(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        String name = map.get("name");
        String location = map.get("location");
        String introduction = map.get("introduction");
        String sstar = map.get("star");
        int star=Integer.parseInt(sstar);
        TourismEnterprise tourismEnterprise=tourismEnterpriseDaoService.findTourismEnterpriseById(id);
        if(name.isEmpty() || location.isEmpty() || introduction.isEmpty() || sstar.isEmpty() )
            return ResultUtil.fail();//各项数据不能为空，否则返回0
        if(tourismEnterprise.getName().equals(name)&&tourismEnterprise.getLocation().equals(location)&&tourismEnterprise.getIntroduction().equals(introduction)&&tourismEnterprise.getStar()==star)
            return ResultUtil.fail(6000,"前后信息不变");//前后信息不变
        if(!tourismEnterprise.getName().equals(name)&&tourismEnterpriseDaoService.findTourismEnterpriseByName(name)!=null)
            return ResultUtil.fail(7000,"更改信息中的企业已经存在");

        tourismEnterprise.setName(name);
        tourismEnterprise.setLocation(location);
        tourismEnterprise.setIntroduction(introduction);
        tourismEnterprise.setStar(star);
        return ResultUtil.success(tourismEnterpriseDaoService.update(tourismEnterprise));
    }

    @GetMapping (value = "findTourismEnterpriseByName")
    @ResponseBody
    @ApiOperation("根据name查找TourismEnterprise")
        //name查找
    Object findTourismEnterpriseByName(@RequestParam String name) {
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
    Object findPageAttractions(@RequestParam int index,@RequestParam int pagesize) {
        List<TourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findPageAttractions(index,pagesize);
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findPageHotels")
    @ResponseBody
    @ApiOperation("查找对应页数的Hotels")
    Object findPageHotels(@RequestParam int index,@RequestParam int pagesize) {
        List<TourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findPageHotels(index,pagesize);
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

    @GetMapping (value = "findPageAgency")
    @ResponseBody
    @ApiOperation("查找对应页数的Agency")
    Object findPageAgency(@RequestParam int index,@RequestParam int pagesize) {
        List<TourismEnterprise> tourismEnterprises=tourismEnterpriseDaoService.findPageAgency(index,pagesize);
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
    ResultUtil<TourismEnterprise> findTourismEnterpriseById(@RequestParam int id) {
        return ResultUtil.success(tourismEnterpriseDaoService.findTourismEnterpriseById(id));
    }

    @GetMapping (value = "selectAllTourismEnterprise")
    @ResponseBody
    @ApiOperation("查找所有TourismEnterprise的id和name")
    Object selectAllTourismEnterprise() {
        List<Map<String, Object>> tourismEnterprises=tourismEnterpriseDaoService.selectAllTourismEnterprise();
        if(!tourismEnterprises.isEmpty())
            return ResultUtil.success(tourismEnterprises);
        else return ResultUtil.fail();
    }

}

