package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//旅行团的信息，与数据库对应的
@Data
@NoArgsConstructor
public class Itinerary {
    private int id;//旅行单id
    private String name;//旅行单名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start_time;//出发时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end_time;//结束时间时间
    private int affiliated_agency;//旅游社
    private String schedule;//行程描述
    private int price;//价格
    private int scenic_spot;//景区
    private String destination;//终点
    private String starting_point;//起点
    private String accommodation;//住宿安排
    private String gathering_place;//集合地点
    private int maximum;//上限人数
}
