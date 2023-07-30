package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warning {
    int id;
    String content;
    int sender;
    String need_cope;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp send_time;
    String title;

    public Warning(String content, int sender, String need_cope, Timestamp send_time, String title) {
        this.content = content;
        this.sender = sender;
        this.need_cope = need_cope;
        this.send_time = send_time;
        this.title = title;
    }
}
