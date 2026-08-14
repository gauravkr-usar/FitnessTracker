package com.project.fitness.dto;
import com.project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActivityResponse {


    private String id;
    private String userId;
    private ActivityType activityType;

    private Map<String, Object> additionalMetrics;

    private Integer duration;
    private String caloriesBurned;

    private LocalTime startTime;
    private LocalTime createTime;
    private LocalTime updateTime;


}
