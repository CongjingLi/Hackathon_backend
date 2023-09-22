package com.citi.hackathon_backend.event.service;

import com.citi.hackathon_backend.event.entity.Notification;

import java.util.List;

public interface NotifyService {
    public void notifyAll(String content,String org);
    public void notifyPeople(String userName,String content);

    public List<Notification> getAll(String userName);
}
