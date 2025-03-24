package org.example.activitytrackingapp.component;


import org.example.activitytrackingapp.services.TrackService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivityScheduler {

    private final TrackService activityService;
    private boolean track = true;

    public ActivityScheduler (TrackService activityService) {
        this.activityService = activityService;
    }

    @Scheduled(fixedRate = 30000)
    public void track() {
        if (track) {
            activityService.checkActivity();
        }
    }

    public void startTracking() {
        track = true;
        track();
    }

    public void stopTracking() {
        track = false;
    }

    public boolean isTracking() {
        return track;
    }
}
