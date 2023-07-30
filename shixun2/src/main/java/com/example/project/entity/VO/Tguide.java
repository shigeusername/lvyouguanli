package com.example.project.entity.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tguide {
    int id;//导游id
    String information;//导游证编号
    int affiliated_agency;//旅行社id
    int itinerary_id;//行程单id
    String academic_degree;//学历
    String speciality;//专业
    String school;//学校
}
