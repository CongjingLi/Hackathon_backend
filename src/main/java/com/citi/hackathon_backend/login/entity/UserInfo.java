package com.citi.hackathon_backend.login.entity;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String userName;
    private String password;
    private String nickName;
    private String address;//optional
    private String email;//optional
    private String organization;
}
