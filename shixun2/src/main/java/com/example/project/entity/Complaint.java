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
    String content;
    int level;
    String if_coped;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    Date send_date;
    String title;

    public Complaint(int sender, int enterprise_id, String content, int level, String if_coped, Date send_date, String title) {
        this.sender = sender;
        this.enterprise_id = enterprise_id;
        this.content = content;
        this.level = level;
        this.if_coped = if_coped;
        this.send_date = send_date;
        this.title = title;
    }
}
