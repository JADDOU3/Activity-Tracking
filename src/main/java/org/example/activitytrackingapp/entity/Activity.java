package org.example.activitytrackingapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;


@Entity
@Table(name = "Activity")
public class Activity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private String activityName;
    private Duration timeSpent;

    public Activity(){}

    public Activity(String activityName, Duration timeSpent , Customer customer){
        this.activityName = activityName;
        this.timeSpent = timeSpent;
        this.customer = customer;
    }
}
