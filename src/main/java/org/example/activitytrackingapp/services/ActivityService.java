package org.example.activitytrackingapp.services;


import lombok.RequiredArgsConstructor;
import org.example.activitytrackingapp.utils.WindowTracker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivityService {

    private String lastApp = "";
    private LocalDateTime startTime = LocalDateTime.now();

    private final CalendarService calendarService;


    public ActivityService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }
    public void checkActivity(){
        String currentApp = WindowTracker.getActiveWindowTitle();

        if(!currentApp.equals(lastApp)){
            if(!lastApp.isBlank()){
                calendarService.logActivityToCalendar(lastApp, startTime, LocalDateTime.now());
            }
            lastApp = currentApp;
            startTime = LocalDateTime.now();
        }
    }
}
