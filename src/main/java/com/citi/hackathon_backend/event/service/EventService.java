package com.citi.hackathon_backend.event.service;

import com.citi.hackathon_backend.event.entity.Event;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EventService {

    public Event createNewEvent(Event event);
    public void updateEventStatus(String documentId, int eventIndex,String status);

    public List<Event> getEvents();
}
