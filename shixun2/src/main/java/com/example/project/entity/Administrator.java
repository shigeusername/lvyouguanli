package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Administrator {
    private int id;
    private int affiliated_enterprise;//隶属于的企业id
    private String name;//管理人员名字
    private int age;//管理人员年龄
    private String gender;//管理人员性别
    private String position;//管理人员职位

    public Administrator(int affiliated_enterprise, String name, int age, String gender, String position) {
        this.affiliated_enterprise = affiliated_enterprise;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position;
    }
}
