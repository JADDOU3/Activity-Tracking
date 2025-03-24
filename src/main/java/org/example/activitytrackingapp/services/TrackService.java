package org.example.activitytrackingapp.services;


import org.example.activitytrackingapp.component.SessionManager;
import org.example.activitytrackingapp.entity.Activity;
import org.example.activitytrackingapp.entity.Customer;
import org.example.activitytrackingapp.repository.ActivityRepo;
import org.example.activitytrackingapp.utils.WindowTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class TrackService {

    private String lastApp = "";
    private LocalDateTime startTime = LocalDateTime.now();

    private ActivityRepo activityRepo;

    @Autowired
    public TrackService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    public void checkActivity(){
        String currentApp = WindowTracker.getActiveWindowTitle();

        if(!currentApp.equals(lastApp)){
            if(!lastApp.isBlank()){
                Customer customer = SessionManager.getCurrentCustomer();
                if(customer != null) {
                    Duration timeSpent = Duration.between(startTime, LocalDateTime.now());
                    Activity activity = new Activity(lastApp, timeSpent, customer);
                    activityRepo.save(activity);
                }
                System.out.println("not logged in");
            }
            lastApp = currentApp;
            startTime = LocalDateTime.now();
        }
    }
}
