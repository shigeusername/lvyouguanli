package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String gender;
    private int type = 0;
    private int phone;
    private String account;
    private String password;
    private String salt;

    public User(String name, String account, String password, String salt) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.salt = salt;
    }
}
