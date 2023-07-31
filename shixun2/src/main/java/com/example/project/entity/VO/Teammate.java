package com.example.project.entity.VO;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teammate {
    private String name;//姓名
    private String gender;//性别
    private int age;//年龄
    private String phone;//联系方式

    public Teammate(String name, String gender, int age, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }
}
