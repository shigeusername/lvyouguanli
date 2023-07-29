package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    private int id;

    private int user_id;

    private String content;

    private String if_succeed;

    private int agency_id;

    private String information;

    private String academic_degree;

    private String speciality;

    private String school;

}
