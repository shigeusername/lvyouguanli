package com.example.project.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintVO {
    int id;
    String  sender;
    String enterprise;
    String context;
    int level;
    String if_coped;
    Date send_date;
}
