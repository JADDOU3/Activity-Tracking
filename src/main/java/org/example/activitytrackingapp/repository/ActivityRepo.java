package org.example.activitytrackingapp.repository;


import org.example.activitytrackingapp.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ActivityRepo extends JpaRepository<Activity, Long> {

}
