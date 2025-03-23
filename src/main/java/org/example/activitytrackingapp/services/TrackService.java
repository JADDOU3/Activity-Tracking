package org.example.activitytrackingapp.services;


import org.example.activitytrackingapp.entity.Activity;
import org.example.activitytrackingapp.utils.WindowTracker;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class TrackService {

    private String lastApp = "";
    private LocalDateTime startTime = LocalDateTime.now();

    private final CalendarService calendarService;


    public TrackService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public void checkActivity(){
        String currentApp = WindowTracker.getActiveWindowTitle();

        if(!currentApp.equals(lastApp)){
            if(!lastApp.isBlank()){
                Duration timeSpent = Duration.between(startTime,LocalDateTime.now());
                Activity activity = new Activity(lastApp , timeSpent);
            }
            lastApp = currentApp;
            startTime = LocalDateTime.now();
        }
    }
}
