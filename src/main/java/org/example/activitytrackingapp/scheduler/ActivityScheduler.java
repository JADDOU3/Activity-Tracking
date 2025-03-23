package org.example.activitytrackingapp.scheduler;


import org.example.activitytrackingapp.services.TrackService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivityScheduler {

    private final TrackService activityService;

    public ActivityScheduler (TrackService activityService) {
        this.activityService = activityService;
    }

    @Scheduled(fixedRate = 60000) // every minute
    public void track() {
        activityService.checkActivity();
    }
}
