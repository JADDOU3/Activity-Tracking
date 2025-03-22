package org.example.activitytrackingapp.scheduler;


import lombok.RequiredArgsConstructor;
import org.example.activitytrackingapp.services.ActivityService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityScheduler {

    private final ActivityService activityService;

    @Scheduled(fixedRate = 60000) // every minute
    public void track() {
        activityService.checkActivity();
    }
}
