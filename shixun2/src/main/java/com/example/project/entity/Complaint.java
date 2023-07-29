package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
    int id;
    int sender;
    int enterprise_id;
    String context;
    int level;
    String if_coped;
    Date send_date;
}
