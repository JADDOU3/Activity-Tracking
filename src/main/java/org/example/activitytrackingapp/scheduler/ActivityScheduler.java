package org.example.activitytrackingapp.scheduler;


import org.example.activitytrackingapp.services.ActivityService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivityScheduler {

    private final ActivityService activityService;

    public ActivityScheduler (ActivityService activityService) {
        this.activityService = activityService;
    }

    @Scheduled(fixedRate = 60000) // every minute
    public void track() {
        activityService.checkActivity();
    }
}
