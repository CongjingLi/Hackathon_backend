package com.citi.hackathon_backend.event.service.impl;

import com.citi.hackathon_backend.event.NotificationRepository;
import com.citi.hackathon_backend.event.entity.Notification;
import com.citi.hackathon_backend.event.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public void notifyAll(String content, String org) {


        //todo:query all users under this org
        /**
         * for (UserInfo user in users){
         * Notification notification=new Notification();
         *         notification.setContent(content);
         *         notification.setOrganization(org);
         *     notification.setUserName(user.getUserName);
         *     notificationRepository.save(notification);
         * }
         *
         *
         */


    }

    @Override
    public void notifyPeople(String userName,String content) {



    }

    @Override
    public List<Notification> getAll(String userName) {
        return notificationRepository.findByUserName(userName);
    }
}
