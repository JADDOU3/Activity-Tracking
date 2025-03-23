package org.example.activitytrackingapp.services;


import jakarta.transaction.Transactional;
import org.example.activitytrackingapp.entity.Activity;
import org.example.activitytrackingapp.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class ActivityService {

    private final ActivityRepo activityRepo;

    @Autowired
    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }


    public Activity save(Activity activity) {
        return activityRepo.save(activity);
    }
}
