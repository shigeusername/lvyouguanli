package com.example.project.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//导游查看的所有行程单的信息
@Data
@NoArgsConstructor
public class Allgi {
    private String t_name;//景区名称
    private String starting_point;//起点
    private String destination;//终点
    private String start_time;//出发时间
    private String end_time;//结束时间
    private String schedule;//活动
    private int i_id; //行程单id

    public Allgi(String t_name, String starting_point, String destination, String start_time, String end_time, String schedule, int i_id) {
        this.t_name = t_name;
        this.starting_point = starting_point;
        this.destination = destination;
        this.start_time = start_time;
        this.end_time = end_time;
        this.schedule = schedule;
        this.i_id = i_id;
    }
}
