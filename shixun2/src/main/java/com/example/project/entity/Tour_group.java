package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

//行程单与用户的链接
@Data
@NoArgsConstructor
public class Tour_group {
    int id;
    int itinerary_id;
    int user_id;

    public Tour_group(int itinerary_id, int user_id) {
        this.itinerary_id = itinerary_id;
        this.user_id = user_id;
    }
}
