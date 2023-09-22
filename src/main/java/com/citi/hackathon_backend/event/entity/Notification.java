package com.citi.hackathon_backend.event.entity;

import lombok.Data;

@Data
public class Notification {
    private Long id;
    private String userName;
    private String organization;
    private String content;


}
