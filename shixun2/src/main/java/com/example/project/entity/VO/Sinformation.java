package com.example.project.entity.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sinformation {
    int id;
    String name;//景区名称
    String type;//类型
    int capacity;
    int parking_space;
    int current_people;
    int current_parking;
    String location;
    double credit;
    String img;//景区图片链接
    String introduction;
    int star;
    Double latitude;
    Double longitude;
}
