package com.example.project.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class GItinerary {
    String g_id;//导游证编号
    int u_id;//导游本身的用户编号
    String img;//string,景区图片链接
    String starting_point;// string,起点
    String destination;//string,终点
    int price;//价格
    String j_name;//string,景区名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime start_time;//LocalDateTime,出发时间
    String gathering_place;// 集合地点
    int current_number;// 旅游团当前人数
    int maximum;// 旅游团上限人数

    public GItinerary(String g_id, int u_id, String img, String starting_point, String destination, int price, String j_name, LocalDateTime start_time, String gathering_place, int current_number, int maximum) {
        this.g_id = g_id;
        this.u_id = u_id;
        this.img = img;
        this.starting_point = starting_point;
        this.destination = destination;
        this.price = price;
        this.j_name = j_name;
        this.start_time = start_time;
        this.gathering_place = gathering_place;
        this.current_number = current_number;
        this.maximum = maximum;
    }
}
