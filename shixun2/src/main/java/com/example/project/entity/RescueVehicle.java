package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RescueVehicle {
    private int id;
    private String license_number;//车牌号
    private String driver_name;//驾驶员姓名
    private int driver_age;//驾驶员年龄
    private String phone;//驾驶员电话
    private int affiliated_enterprise;//驾驶员所属的企业
    private String driver_gender;//驾驶员性别

    public RescueVehicle(String license_number, String driver_name, int driver_age, String phone, int affiliated_enterprise, String driver_gender) {
        this.license_number = license_number;
        this.driver_name = driver_name;
        this.driver_age = driver_age;
        this.phone = phone;
        this.affiliated_enterprise = affiliated_enterprise;
        this.driver_gender = driver_gender;
    }
}
