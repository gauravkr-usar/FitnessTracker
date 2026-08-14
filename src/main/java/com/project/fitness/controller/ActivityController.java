package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {

        return ResponseEntity.ok(activityService.trackActivity(request));
    }
//    @GetMapping
//    public ResponseEntity<List<ActivityResponse>> trackActivity(){
//        return "";
    }

