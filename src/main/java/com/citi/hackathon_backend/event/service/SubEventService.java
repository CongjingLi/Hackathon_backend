package com.citi.hackathon_backend.event.service;

import com.citi.hackathon_backend.event.entity.SubEvent;

import java.util.List;

public interface SubEventService {
    public SubEvent createSubEvent(SubEvent subEvent);
    public void updateSubEventStatus(Long eventId, int subEventIndex, String status);

    public SubEvent querySubeventById(Long id);
    public List<SubEvent> querySubeventByEventId(Long eventId);
    public List<SubEvent> querySubevents();
}
