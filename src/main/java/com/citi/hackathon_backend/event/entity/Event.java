package com.citi.hackathon_backend.event.entity;

import lombok.Data;

import java.util.List;

@Data
public class Event {
    private Long id;
    private Long documentId;
    private String organization;
    private int currentSubEventPosition;
    private String assignee;
    private String description;
    private String createTime;
    private String completeTime;
    private String notificationReceiver;
    private List<SubEvent> subEventList;
    private int eventIndex;
    private EventStatus eventStatus;
}
