package com.citi.hackathon_backend.volunteerInfo.repository;

import com.citi.hackathon_backend.volunteerInfo.entity.VolunteerInfo;
import org.springframework.data.repository.CrudRepository;

public interface VolunteerInfoRepository extends CrudRepository<VolunteerInfo, String>{
	
}
