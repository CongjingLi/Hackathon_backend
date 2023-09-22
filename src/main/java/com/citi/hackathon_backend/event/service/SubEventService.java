package com.citi.hackathon_backend.event.service;

import com.citi.hackathon_backend.event.entity.SubEvent;

import java.util.List;

public interface SubEventService {
    public SubEvent createSubEvent(SubEvent subEvent);
    public void updateSubEventStatus(String eventId, int subEventIndex, String status);

    public SubEvent querySubeventById(String id);
    public List<SubEvent> querySubeventByEventId(String eventId);
    public List<SubEvent> querySubevents();
}
