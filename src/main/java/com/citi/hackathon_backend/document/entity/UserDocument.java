package com.citi.hackathon_backend.document.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.citi.hackathon_backend.event.convert.JsonToListEvents;
import com.citi.hackathon_backend.event.entity.Event;
import lombok.Data;

import java.util.List;

@Data
public class UserDocument {
    private String id;
    private String name;
    private String authenticationId;
    //other information;

    private String createTime;
    private int currentEventPosition;
    private String createUserName;
    @DynamoDBTypeConverted(converter = JsonToListEvents.class)
    private List<Event> eventList;

}
