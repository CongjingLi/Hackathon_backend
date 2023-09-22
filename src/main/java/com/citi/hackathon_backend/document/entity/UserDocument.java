package com.citi.hackathon_backend.document.entity;

import com.citi.hackathon_backend.event.entity.Event;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDocument {
    private Long id;
    private String name;
    private String authenticationId;
    //other information;

    private String createTime;
    private int currentEventPosition;
    private List<Event> eventList;

}
