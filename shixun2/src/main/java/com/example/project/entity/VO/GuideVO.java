package com.example.project.entity.VO;

import com.example.project.entity.Guide;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuideVO extends Guide {
    String name;
    String gender;
    String phone;
    String agency_name;
    String itinerary_name;
}
