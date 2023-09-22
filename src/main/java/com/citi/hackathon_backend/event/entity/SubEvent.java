package com.citi.hackathon_backend.event.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SubEvent {
    private Long id;
    private int subEventIndex;
    private Long eventId;
    private String organization;
    private String assignee;
    private String description;
    private String createTime;
    private String completeTime;
    private String notificationReceiver;
    private String createUserName;
    private EventStatus eventStatus;

    public String convertToString() {
        return String.format("org:%s, description:%s, create time:%s, event status", this.organization, this.description, this.createTime, this.eventStatus);
    }
}
