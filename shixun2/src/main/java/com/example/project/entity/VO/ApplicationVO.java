package com.example.project.entity.VO;

import com.example.project.entity.Application;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplicationVO extends Application{
    String user_name;
    String user_phone;
    String agency_name;
}
