package com.example.project.entity.VO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//旅行团详情界面所需数据
@Data
@NoArgsConstructor
public class Xitin {
    private String j_name;//景区名

    private String start_time;//出发时间
    private int price;//价格
    private String gathering_place;//集合地点
    private String starting_point;//起点
    private String destination;//终点
    private String accommodation;//住宿安排
    private String schedule;//具体路线
    private int current_number;//旅游团当前人数
    private int maximum;//旅游团上限人数
    private String g_name;//导游

    public Xitin(String j_name, String start_time, int price, String gathering_place, String starting_point, String destination, String accommodation, String schedule, int current_number, int maximum, String g_name) {
        this.j_name = j_name;
        this.start_time = start_time;
        this.price = price;
        this.gathering_place = gathering_place;
        this.starting_point = starting_point;
        this.destination = destination;
        this.accommodation = accommodation;
        this.schedule = schedule;
        this.current_number = current_number;
        this.maximum = maximum;
        this.g_name = g_name;
    }
}
