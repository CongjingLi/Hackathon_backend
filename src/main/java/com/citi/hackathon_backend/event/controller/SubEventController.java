package com.citi.hackathon_backend.event.controller;

import com.citi.hackathon_backend.event.entity.SubEvent;
import com.citi.hackathon_backend.event.service.SubEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subevent")
public class SubEventController {
    @Autowired
    SubEventService subEventService;

    @PostMapping(value = "/createSubEvent")
    SubEvent createSubEvent(@RequestBody SubEvent newSubEvent) {
        return subEventService.createSubEvent(newSubEvent);
    }

    @PostMapping(value = "/updateSubEventStatus")
    String createSubEvent(@RequestParam(name = "eventId") Long eventId, @RequestParam int subEventIndex, @RequestParam String status) {
        try {
            subEventService.updateSubEventStatus(eventId, subEventIndex, status);
        } catch (Exception e) {
            System.out.println(this.getClass() + "ERROR" + e.getMessage());
            return "failed";
        }
        return "success";
    }

    @GetMapping(value = "/querySubeventById")
    SubEvent querySubeventById(@PathVariable Long id) {
        return subEventService.querySubeventById(id);
    }

    @GetMapping(value = "/querySubeventByEventId")
    List<SubEvent> querySubeventByEventId(@PathVariable Long eventId) {
        return subEventService.querySubeventByEventId(eventId);
    }

    @GetMapping(value = "/querySubevents")
    List<SubEvent> querySubevents() {
        return subEventService.querySubevents();
    }
}
