package com.citi.hackathon_backend.event.controller;

import com.citi.hackathon_backend.event.EventRepository;
import com.citi.hackathon_backend.event.entity.Event;
import com.citi.hackathon_backend.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(value = "/test")
    String test(){
return"success";
    }
}
