package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    Date send_date;
    String title;
}
