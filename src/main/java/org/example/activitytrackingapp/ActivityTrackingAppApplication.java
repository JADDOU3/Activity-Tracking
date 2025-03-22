package org.example.activitytrackingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ActivityTrackingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityTrackingAppApplication.class, args);
    }

}
