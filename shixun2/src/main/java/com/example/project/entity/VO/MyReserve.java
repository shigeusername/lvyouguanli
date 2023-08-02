package com.example.project.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//我的预约信息
@Data
@NoArgsConstructor
public class MyReserve {
    private String starting_point;//起点
    private String destination;//终点
    private String j_name;//景区名
    private String start_time;//出发时间
    private int price;//价格
    private int id;//旅行单id

    public MyReserve(String starting_point, String destination, String j_name, String start_time, int price, int id) {
        this.starting_point = starting_point;
        this.destination = destination;
        this.j_name = j_name;
        this.start_time = start_time;
        this.price = price;
        this.id = id;
    }
}
