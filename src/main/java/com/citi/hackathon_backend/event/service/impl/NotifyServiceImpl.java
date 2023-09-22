package com.citi.hackathon_backend.event.service.impl;

import com.citi.hackathon_backend.event.NotificationRepository;
import com.citi.hackathon_backend.event.entity.Notification;
import com.citi.hackathon_backend.event.service.NotifyService;
import com.citi.hackathon_backend.userInfo.UserRepository;
import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void notifyAll(String content, String org) {

        List<UserInfo> users = userRepository.findByOrganization(org);
        for (UserInfo user : users) {
            Notification notification=new Notification();
            notification.setOrganization(user.getOrganization());
            notification.setContent(content);
            notification.setUserName(user.getUserName());
            notificationRepository.save(notification);
        }

    }

    @Override
    public void notifyPeople(String userName, String content) {
        UserInfo userInfo = userRepository.findByUserName(userName);
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setUserName(userName);
        notification.setOrganization(userInfo.getOrganization());
        notificationRepository.save(notification);

    }

    @Override
    public List<Notification> getAll(String userName) {
        return notificationRepository.findByUserName(userName);
    }
}
