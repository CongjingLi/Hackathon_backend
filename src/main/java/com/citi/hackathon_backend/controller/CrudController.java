package com.citi.hackathon_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.hackathon_backend.userInfo.repository.UserInfoRepository;
import com.citi.hackathon_backend.volunteerInfo.repository.VolunteerInfoRepository;


@RestController
@RequestMapping("/api")
public class CrudController {
	
	@Autowired
	private VolunteerInfoRepository volunteerInfoRepositor;
	
	@Autowired
	private UserInfoRepository userInfoRepositor;

}
