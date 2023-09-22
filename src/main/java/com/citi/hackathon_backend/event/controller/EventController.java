package com.citi.hackathon_backend.event.controller;

import com.citi.hackathon_backend.event.EventRepository;
import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.entity.EventStatus;
import com.citi.hackathon_backend.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    EventRepository eventRepository;

    @PostMapping(value = "/createNewEvent")
    Event createNewEvent(@RequestBody Event newEvent){
        return eventService.createNewEvent(newEvent);
    }

    @PostMapping(value = "/updateEventStatus")
    String updateStatus(@RequestParam String documentId, @RequestParam int eventIndex,@RequestParam String status){
        try {
            eventService.updateEventStatus(documentId, eventIndex, status);
        } catch (Exception e){
            //log
            return "failed";
        }
        return "success";
    }

    @GetMapping(value = "/queryEvents")
    List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping(value = "/queryEventById")
    List<Event> getEventById(@PathVariable Long id){
        return eventService.getEvents();
    }


//    @GetMapping(value = "/test")
//    String test(){
////        Event event1 = new Event();
////        event1.setAssignee("Lee");
////        event1.setEventIndex(0);
////        event1.setEventStatus(EventStatus.COMPLETED);
////        event1.setDescription("create document");
////        event1.setCompleteTime("2022-15-13");
////        event1.setCreateTime("2022-15-20");
////        event1.setOrganization("Springboard");
////        event1.setDocumentId("1514L");
////        event1.setNotificationReceiver("Lee");
////        return eventRepository.save(event1).toString();
//        return eventRepository.findById("78abb8f3-1957-47f4-a5c2-90a441eb432f").toString();
//
//    }
}
