package com.citi.hackathon_backend.event;

import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.entity.Notification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface NotificationRepository extends CrudRepository<Notification, Long> {
    List<Notification> findByUserName(String userName);
}
