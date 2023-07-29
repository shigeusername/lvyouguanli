package com.example.project.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarningVO {
    int id;
    String content;
    String sender;
    String need_cope;
    Date send_time;
}
