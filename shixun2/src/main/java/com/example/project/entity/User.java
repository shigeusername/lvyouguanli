package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String account;
    private String password;
    private String name;
    private String salt;
    private int age;
    private String gender;
    private int type;
    private String phone;

    public User(String account, String password, String name, String salt){
        this.password = password;
        this.account = account;
        this.name = name;
        this.salt=salt;
    }

    public User(int id, String account, String password, String name, String salt, int age, String gender, int type, String phone) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.salt = salt;
        this.age = age;
        this.gender = gender;
        this.type = type;
        this.phone = phone;
    }
}

