package com.example.project.entity.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConciseTourismEnterprise {
    private int id;
    private String name;//名称
    private String img;//图片
    private String introduction;//介绍

    public ConciseTourismEnterprise(String name, String img, String introduction) {
        this.name = name;
        this.img = img;
        this.introduction = introduction;
    }
}
