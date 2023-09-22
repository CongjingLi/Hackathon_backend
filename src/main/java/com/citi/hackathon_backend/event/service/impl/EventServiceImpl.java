package com.citi.hackathon_backend.event.service.impl;

import com.citi.hackathon_backend.document.entity.UserDocument;
import com.citi.hackathon_backend.event.EventRepository;
import com.citi.hackathon_backend.event.StringUtil;
import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.entity.EventStatus;
import com.citi.hackathon_backend.event.entity.Notification;
import com.citi.hackathon_backend.event.service.EventService;
import com.citi.hackathon_backend.event.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.citi.hackathon_backend.event.EventConstants.*;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    NotifyService notifyService;
    private SimpleDateFormat SDF = new SimpleDateFormat("HH:mm dd-MM-yyyy");

    @Override
    public Event createNewEvent(Event event) {
        event.setEventStatus(EventStatus.CREATED);
        event.setCreateTime(SDF.format(new Date()));

        String content = String.format(eventCreatedMessage, event.convertToString(), event.getId());
        if (StringUtil.isNull(event.getAssignee())) {
            notifyService.notifyAll(content, event.getOrganization());
        } else {
            notifyService.notifyPeople(event.getAssignee(), content);
        }

        if (StringUtil.isNull(event.getNotificationReceiver())) {
            event.setNotificationReceiver(event.getCreateUserName());
        }

        UserDocument document = new UserDocument();//todo:query by id from db
        List<Event> eventList = document.getEventList();
        if (eventList == null) {
            eventList = new ArrayList<>();
        }
        eventList.add(event);
        event.setEventIndex(document.getCurrentEventPosition());
        document.setCurrentEventPosition(document.getCurrentEventPosition() + 1);
//todo:save document
        return eventRepository.save(event);
    }

    @Override
    public void updateEventStatus(String documentId, int eventIndex, String status) {
        UserDocument document = new UserDocument();//todo:query from db
        Event event = document.getEventList().get(eventIndex);
        String content = "";
        switch (status) {
            case "CANCELLED":
                event.setEventStatus(EventStatus.CANCELLED);
                content = String.format(eventCancelledMessage, event.convertToString(), event.getId());
                break;
            case "IN_PROCESS":
                event.setEventStatus(EventStatus.IN_PROGRESS);
                content = String.format(eventStartedMessage, event.convertToString(), event.getId());
                break;
            case "COMPLETED":
                event.setEventStatus(EventStatus.COMPLETED);
                event.setCompleteTime(SDF.format(new Date()));
                content = String.format(eventCompletedMessage, event.convertToString(), event.getId());
                break;
        }
        notifyService.notifyPeople(event.getNotificationReceiver(), content);
        eventRepository.save(event);

        Event[] events = document.getEventList().toArray(new Event[document.getCurrentEventPosition()]);
        events[event.getEventIndex()] = event;
        document.setEventList(Arrays.stream(events).toList());
        //todo:save document
    }

    @Override
    public List<Event> getEvents() {
        return (List<Event>) eventRepository.findAll();
    }


}
