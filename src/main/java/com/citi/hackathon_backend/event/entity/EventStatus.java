package com.citi.hackathon_backend.event.entity;

public enum EventStatus {
    IN_PROGRESS("event is in progress"),
    COMPLETED("event has been completed"),
    CREATED("event has been created but not start"),
    CANCELLED("event has been created but not cancelled");
    private String description;

    EventStatus(String description) {
        this.description=description;
    }


}
