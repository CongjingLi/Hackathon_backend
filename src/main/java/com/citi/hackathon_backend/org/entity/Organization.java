package com.citi.hackathon_backend.org.entity;

import lombok.Data;

@Data
public class Organization {
    private Long id;
    private String orgName;
    private String address;
    private String contactPerson;
}
