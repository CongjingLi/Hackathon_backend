package com.citi.hackathon_backend.volunteerInfo.entity;

import lombok.Data;

@Data
public class VolunteerInfo {
    private String id;
    private String nickName;
    private String address;
    private String email;//optional
    private String organization;
    private String personalDescription;
}
