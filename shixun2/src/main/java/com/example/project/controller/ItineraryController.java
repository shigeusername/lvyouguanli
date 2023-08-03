package com.example.project.controller;

import com.example.project.common.ResultUtil;
import com.example.project.entity.Itinerary;
import com.example.project.entity.Tour_group;
import com.example.project.entity.User;
import com.example.project.entity.VO.*;
import com.example.project.service.ItineraryDaoServicelmpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api
@RestController
@RequestMapping("itinerary")
public class ItineraryController {
    @Autowired
    ItineraryDaoServicelmpl itineraryDaoServicelmpl;


    //旅客获取全部的旅行单信息
    //旅行单是被导游申领过的，并且开始时间应当晚于或者等于目前时间的
    @PostMapping("/getall")
    ResultUtil getall(@RequestBody HashMap<String, String> map){
        String i_name = map.get("i_name");
        System.out.println(i_name);
        String time = map.get("time");
        int price_up = Integer.parseInt(map.get("price_up"));
        int price_down = Integer.parseInt(map.get("price_down"));
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        List<Itinerary> Li = itineraryDaoServicelmpl.findall(i_name,price_up,price_down);
        List<Alliten> Ai = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();
        for (Itinerary i:Li){
            int s = i.getScenic_spot();
            String name = itineraryDaoServicelmpl.findjbyid(s);

            //若预约人数已达上限，则不予显示
            int mxx = i.getMaximum();
            int iii = i.getId();
            int current_number = itineraryDaoServicelmpl.countTGById(iii);//旅游团当前人数
            //System.out.println("now people :" + current_number + "  mxx: " + mxx);
            if (current_number == mxx) continue;

            int f1 = 0, f2 = 0;
            //筛选日期
            if(time == ""){
                f1 = 0;
                f2 = 0;
            }else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate ytime = LocalDate.parse(time, formatter);
                f1 = ytime.compareTo(i.getStart_time().toLocalDate());
                f2 = ytime.compareTo(i.getEnd_time().toLocalDate());
            }


            LocalDateTime dateTime = LocalDateTime.now(); // 获取当前日期和时间
            LocalDate datenow = dateTime.toLocalDate(); // 提取日期部分
            int f3 = datenow.compareTo(i.getStart_time().toLocalDate());
            System.out.println(f3+ "   " + i.getStart_time());
            if(f1 >= 0 && f2 <= 0 && f3 <= 0) {
                String starting_point = i.getStarting_point();//起点
                String destination=i.getDestination();//终点
                String t_name=name;//景区名

                LocalDateTime start_time=i.getStart_time();//出发时间
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                // Convert the LocalDateTime object to a string using the formatter
                String start_time0 = start_time.format(formatter);

                int price=i.getPrice();//价格
                int id = i.getId();
                Alliten alliten = new Alliten(starting_point,destination, t_name,start_time0,price,id);
                Ai.add(alliten);
            }else continue;
        }
        int size = Ai.size();
        List<Alliten> ra = new ArrayList<>();
        if(pageSize >= size && pageNum == 1) ra = Ai;//这里逻辑比较抽象
        else if (pageNum * pageSize > size ) ra = Ai.subList((pageNum - 1) * pageSize,size);   // 提取新的List对象
        else ra = Ai.subList((pageNum - 1) * pageSize,pageNum * pageSize);
        res.put("size", size);
        res.put("information",ra);
        return ResultUtil.success(res);
    }


    //查看旅行团详情
    @PostMapping("/findxjbyid")
    ResultUtil findxjbyid(@RequestBody HashMap<String, String> map){
        int id = Integer.parseInt(map.get("id"));
        Itinerary itinerary = itineraryDaoServicelmpl.findxjbyid(id);
        int s = itinerary.getAffiliated_agency();
        String j_name = itineraryDaoServicelmpl.findjbyid(s);//景区名
        LocalDateTime start_time = itinerary.getStart_time();//出发时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Convert the LocalDateTime object to a string using the formatter
        String start_time0 = start_time.format(formatter);

        int price = itinerary.getPrice();//价格
        String gathering_place = itinerary.getGathering_place();//集合地点
        String starting_point = itinerary.getStarting_point();//起点
        String destination = itinerary.getDestination();//终点
        String accommodation = itinerary.getAccommodation();//住宿安排
        String schedule = itinerary.getSchedule();//具体路线
        int current_number = itineraryDaoServicelmpl.countTGById(id);//旅游团当前人数
        int maximum = itinerary.getMaximum();//旅游团上线人数
        String g_name = itineraryDaoServicelmpl.findGNById(id);//导游
        Xitin xitin = new Xitin(j_name,start_time0,price,gathering_place,starting_point,destination,accommodation,schedule,current_number,maximum,g_name);
        return ResultUtil.success(xitin);
    }

    //添加预约信息
    @PostMapping("/reserve")
    ResultUtil reserve(@RequestBody HashMap<String, String> map) {
        int t_id = Integer.parseInt(map.get("t_id"));
        int u_id = Integer.parseInt(map.get("u_id"));
        int z = itineraryDaoServicelmpl.reverseTG(t_id ,u_id);
        return ResultUtil.success(1);
    }

    //查看我的预约信息
    @PostMapping("/getmyreserve")
    ResultUtil getmyreserve(@RequestBody HashMap<String, String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        int u_id = Integer.parseInt(map.get("id"));

        List<Tour_group> TG = itineraryDaoServicelmpl.getMyReverse(u_id);
        List<MyReserve> LMi= new ArrayList<>();

        for (Tour_group tg: TG){
            int id = tg.getItinerary_id();//旅行单id
            Itinerary itinerary = itineraryDaoServicelmpl.findxjbyid(id);
            String starting_point = itinerary.getStarting_point();//起点
            String destination = itinerary.getDestination();//终点
            int s = itinerary.getAffiliated_agency();
            String j_name = itineraryDaoServicelmpl.findjbyid(s);//景区名
            LocalDateTime start_time = itinerary.getStart_time();//出发时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // Convert the LocalDateTime object to a string using the formatter
            String start_time0 = start_time.format(formatter);
            int price = itinerary.getPrice();//价格
            MyReserve myReserve = new MyReserve(starting_point,destination,j_name,start_time0,price,id);
            LMi.add(myReserve);
        }
        int size = LMi.size();
        List<MyReserve> RLMi= new ArrayList<>();
        if(pageSize >= size && pageNum == 1) RLMi = LMi;
        else if (pageNum * pageSize > size ) RLMi = LMi.subList((pageNum - 1) * pageSize,size);   // 提取新的List对象
        else RLMi = LMi.subList((pageNum - 1) * pageSize,pageNum * pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("size", size);
        res.put("information",RLMi);
        return ResultUtil.success(res);
    }

    //取消行程单预约
    @DeleteMapping("/detelereverse")
    ResultUtil detelereverse(@RequestBody HashMap<String, String> map) {
        int i_id = Integer.parseInt(map.get("i_id"));
        int u_id = Integer.parseInt(map.get("u_id"));
        int z = itineraryDaoServicelmpl.deleteTGByUIII(u_id ,i_id);
        return ResultUtil.success(1);
    }

    //导游查看我的行程单信息
    @PostMapping("/findgitin")
    ResultUtil findgitin(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        Tguide tguide = itineraryDaoServicelmpl.getGuideById(id);
        int i_id = tguide.getItinerary_id();
        System.out.println(i_id);
        if (i_id == 0) {
            Map<String, Object> res = new HashMap<>();
            res.put("g_id", id);
            res.put("u_id",tguide.getInformation());
            return ResultUtil.success(res);
        }
        Itinerary itinerary = itineraryDaoServicelmpl.findxjbyid(i_id);
        Sinformation sinformation = itineraryDaoServicelmpl.findTNameImgById(itinerary.getScenic_spot());
        String g_id = tguide.getInformation();//导游证编号
        int u_id = id;//导游本身的用户编号
        String img = sinformation.getImg();//string,景区图片链接
        String starting_point = itinerary.getStarting_point();// string,起点
        String destination = itinerary.getDestination();//string,终点
        int price = itinerary.getPrice();//价格
        String j_name = sinformation.getName();//string,景区名
        LocalDateTime start_time = itinerary.getStart_time();//LocalDateTime,出发时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Convert the LocalDateTime object to a string using the formatter
        String start_time0 = start_time.format(formatter);
        LocalDateTime dateTime = LocalDateTime.now(); // 获取当前日期和时间
        LocalDate datenow = dateTime.toLocalDate(); // 提取日期部分
        int f3 = datenow.compareTo(itinerary.getEnd_time().toLocalDate());
        if(f3 > 0) return ResultUtil.success(null);
        System.out.println(f3);
        String gathering_place = itinerary.getGathering_place();// 集合地点
        int current_number = itineraryDaoServicelmpl.countTGById(i_id);// 旅游团当前人数
        int maximum = itinerary.getMaximum();// 旅游团上限人数
        GItinerary gItinerary = new GItinerary(g_id,u_id,img,starting_point,destination,price,j_name,start_time0,gathering_place,current_number,maximum);
        return ResultUtil.success(gItinerary);
    }


    //查看所有团成员
    @PostMapping("/findgroupmate")
    ResultUtil findgroupmate(@RequestBody HashMap<String, String> map) {
        int g_id = Integer.parseInt(map.get("g_id"));
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        List<User> LUi = itineraryDaoServicelmpl.findUserByGid(g_id);
        List<Teammate> LTi = new ArrayList<>();
        for(User user: LUi){
            Teammate teammate =new Teammate(user.getName(), user.getGender(), user.getAge(),user.getPhone());
            LTi.add(teammate);
        }

        int size = LTi.size();
        List<Teammate> RLTi= new ArrayList<>();
        if(pageSize >= size && pageNum == 1) RLTi = LTi;//这里逻辑比较抽象
        else if (pageNum * pageSize > size ) RLTi = LTi.subList((pageNum - 1) * pageSize,size);   // 提取新的List对象
        else RLTi = LTi.subList((pageNum - 1) * pageSize,pageNum * pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("size", size);
        res.put("information",RLTi);
        return ResultUtil.success(res);
    }

    //导游查看全部行程单信息
    //这里行程单是未被申领并且开始时间在今天之后的
    @PostMapping("/findallitinerary")
    ResultUtil findallitinerary(@RequestBody HashMap<String, String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        List<Itinerary> Li= itineraryDaoServicelmpl.findAllGuide();
        List<Allgi> Alli = new ArrayList<>();
        for(Itinerary itinerary:Li){
            LocalDateTime dateTime = LocalDateTime.now(); // 获取当前日期和时间
            LocalDate datenow = dateTime.toLocalDate(); // 提取日期部分
            int f3 = datenow.compareTo(itinerary.getStart_time().toLocalDate());
            if(f3 > 0) continue;
            String name = itineraryDaoServicelmpl.findjbyid(itinerary.getScenic_spot());
            LocalDateTime start_time = itinerary.getStart_time();//LocalDateTime,出发时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // Convert the LocalDateTime object to a string using the formatter
            String start_time0 = start_time.format(formatter);

            LocalDateTime end_time = itinerary.getEnd_time();//LocalDateTime,出发时间
            // Convert the LocalDateTime object to a string using the formatter
            String end_time0 = start_time.format(formatter);

            Allgi allgi = new Allgi(name, itinerary.getStarting_point(), itinerary.getDestination(), start_time0,end_time0,itinerary.getSchedule(),itinerary.getId());
            Alli.add(allgi);
        }
        int size = Alli.size();
        List<Allgi> RAlli= new ArrayList<>();
        if(pageSize >= size && pageNum == 1) RAlli = Alli;//这里逻辑比较抽象
        else if (pageNum * pageSize > size ) RAlli = Alli.subList((pageNum - 1) * pageSize,size);   // 提取新的List对象
        else RAlli = Alli.subList((pageNum - 1) * pageSize,pageNum * pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("size", size);
        res.put("information",RAlli);
        return ResultUtil.success(res);
    }

    @PostMapping("/gapplyi")
    ResultUtil gapplyi(@RequestBody HashMap<String, String> map) {
        int i_id = Integer.parseInt(map.get("i_id"));
        int g_id = Integer.parseInt(map.get("g_id"));
        itineraryDaoServicelmpl.updateGIIdById(i_id,g_id);
        return ResultUtil.success(1);
    }

}
