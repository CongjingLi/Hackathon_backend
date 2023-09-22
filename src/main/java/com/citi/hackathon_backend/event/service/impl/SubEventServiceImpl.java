package com.citi.hackathon_backend.event.service.impl;

import com.citi.hackathon_backend.document.entity.UserDocument;
import com.citi.hackathon_backend.event.EventRepository;
import com.citi.hackathon_backend.event.StringUtil;
import com.citi.hackathon_backend.event.SubEventRepository;
import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.entity.EventStatus;
import com.citi.hackathon_backend.event.entity.SubEvent;
import com.citi.hackathon_backend.event.service.NotifyService;
import com.citi.hackathon_backend.event.service.SubEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.citi.hackathon_backend.event.EventConstants.*;

@Service
public class SubEventServiceImpl implements SubEventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SubEventRepository subEventRepository;
    @Autowired
    NotifyService notifyService;
    private SimpleDateFormat SDF = new SimpleDateFormat("HH:mm dd-MM-yyyy");

    @Override
    public SubEvent createSubEvent(SubEvent subEvent) {
        System.out.println(this.getClass()+"info:start createSubevent"+subEvent);
        Event event = eventRepository.findById(subEvent.getEventId()).get();
        subEvent.setEventStatus(EventStatus.CREATED);
        UserDocument document = new UserDocument();//todo:query form db
        subEvent.setCreateTime(SDF.format(new Date()));

        String content = String.format(eventCreatedMessage, subEvent.convertToString(), subEvent.getId());
        if (StringUtil.isNull(subEvent.getAssignee())) {
            notifyService.notifyAll(content, subEvent.getOrganization());
        } else {
            notifyService.notifyPeople(subEvent.getAssignee(), content);
        }
        System.out.println(this.getClass()+"info:assignee is"+subEvent.getAssignee());
        if (StringUtil.isNull(subEvent.getNotificationReceiver())) {
            subEvent.setNotificationReceiver(subEvent.getCreateUserName());
        }
        System.out.println(this.getClass()+"info:NotificationReceiver is"+subEvent.getNotificationReceiver());
        List<SubEvent> subEventList = event.getSubEventList();
        if (subEventList == null) {
            subEventList = new ArrayList<>();
        }
        subEventList.add(subEvent);
        event.setCurrentSubEventPosition(event.getCurrentSubEventPosition() + 1);
        subEventRepository.save(subEvent);
        eventRepository.save(event);
        Event[] events = document.getEventList().toArray(new Event[document.getCurrentEventPosition()]);
        events[event.getEventIndex()] = event;
        document.setEventList(Arrays.stream(events).toList());
        //todo:save document

        System.out.println(this.getClass()+"info: create completed");
        return subEvent;


    }

    @Override
    public void updateSubEventStatus(String eventId, int subEventIndex, String status) {
        System.out.println(this.getClass()+"info:start update status for "+eventId+"subevent is"+subEventIndex);
        Event event = eventRepository.findById(eventId).get();
        SubEvent subEvent = event.getSubEventList().get(subEventIndex);
        UserDocument document = new UserDocument();//todo:query form db
        String content = "";
        switch (status) {
            case "CANCELLED":
                subEvent.setEventStatus(EventStatus.CANCELLED);
                content = String.format(eventCancelledMessage, subEvent.convertToString(), subEvent.getId());
                break;
            case "IN_PROCESS":
                subEvent.setEventStatus(EventStatus.IN_PROGRESS);
                content = String.format(eventStartedMessage, subEvent.convertToString(), subEvent.getId());
                break;
            case "COMPLETED":
                subEvent.setEventStatus(EventStatus.COMPLETED);
                subEvent.setCompleteTime(SDF.format(new Date()));
                content = String.format(eventCompletedMessage, subEvent.convertToString(), subEvent.getId());
                break;
        }

        System.out.println(this.getClass()+"info:subevent status is "+subEvent.getEventStatus());
        notifyService.notifyPeople(subEvent.getNotificationReceiver(), content);
        SubEvent[] subEvents = event.getSubEventList().toArray(new SubEvent[event.getCurrentSubEventPosition()]);
        subEvents[subEventIndex] = subEvent;
        event.setSubEventList(Arrays.stream(subEvents).toList());

        Event[] events = document.getEventList().toArray(new Event[document.getCurrentEventPosition()]);
        events[event.getEventIndex()] = event;
        document.setEventList(Arrays.stream(events).toList());

        //todo:save document;

        System.out.println(this.getClass()+"info: update completed");

    }

    @Override
    public SubEvent querySubeventById(String id) {
        return subEventRepository.findById(id).get();
    }

    @Override
    public List<SubEvent> querySubeventByEventId(String eventId) {
        Event event = eventRepository.findById(eventId).get();
        return event.getSubEventList();
    }

    @Override
    public List<SubEvent> querySubevents() {
        return (List<SubEvent>) subEventRepository.findAll();
    }
}
