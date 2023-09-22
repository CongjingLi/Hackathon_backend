package com.citi.hackathon_backend.event;

import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface NotificationRepository extends CrudRepository<Notification, String> {
    List<Notification> findByUserName(String userName);
}
