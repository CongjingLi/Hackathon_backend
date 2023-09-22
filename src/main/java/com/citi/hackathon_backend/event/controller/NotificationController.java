package com.citi.hackathon_backend.event.controller;

import com.citi.hackathon_backend.event.entity.Notification;
import com.citi.hackathon_backend.event.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {
    @Autowired
    NotifyService notifyService;

    @GetMapping(value = "/getAll")
    List<Notification> getAllNotifications(@RequestParam("userName") String userName) {
        return notifyService.getAll(userName);

    }
}
