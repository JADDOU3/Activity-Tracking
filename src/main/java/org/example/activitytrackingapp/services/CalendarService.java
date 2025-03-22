package org.example.activitytrackingapp.services;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CalendarService {


    public void logActivityToCalendar(String app, LocalDateTime start, LocalDateTime end) {
        // TODO: Implement Google Calendar API integration
        System.out.println("Log Activity → " + app + " | " + start + " - " + end);
    }
}
