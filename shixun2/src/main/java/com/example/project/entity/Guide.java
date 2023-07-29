package com.example.project.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
    private int id;

    private int affiliated_agency;

    private int itinerary_id;

    private String information;

    private String academic_degree;

    private String speciality;

    private String school;
}
