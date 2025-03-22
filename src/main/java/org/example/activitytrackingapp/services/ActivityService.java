package org.example.activitytrackingapp.services;


import lombok.RequiredArgsConstructor;
import org.example.activitytrackingapp.utils.WindowTracker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private String lastApp = "";
    private LocalDateTime startTime = LocalDateTime.now();

    private CalendarService calendarService;

    public void checkActivity(){
        String currentApp = WindowTracker.getActiveWindowTitle();

        if(!currentApp.equals(lastApp)){
            if(!lastApp.isBlank()){
                //implement log to store activity
            }
            lastApp = currentApp;
            startTime = LocalDateTime.now();
        }
    }
}
