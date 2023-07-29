package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TourismEnterprise {
    private int id;
    private String name;//名称
    private String type;//类型（1是旅游景区 2是星级酒店 3是旅行社）
    private int capacity;//最大游客容量
    private int parking_space;//停车位总数量
    private int current_people;//当前人数
    private int current_parking;//当前车位数
    private String location;//旅游企业位置
    private int credit;//诚信状况分数
    private String img;//图片
    private String introduction;//介绍
    private int star;//星级
    private double latitude;//经度
    private double longitude;//纬度

    public TourismEnterprise(String name, String type, int capacity, int parking_space, int current_people, int current_parking, String location, int credit, String img, String introduction, int star, double latitude, double longitude) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.parking_space = parking_space;
        this.current_people = current_people;
        this.current_parking = current_parking;
        this.location = location;
        this.credit = credit;
        this.img = img;
        this.introduction = introduction;
        this.star = star;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
