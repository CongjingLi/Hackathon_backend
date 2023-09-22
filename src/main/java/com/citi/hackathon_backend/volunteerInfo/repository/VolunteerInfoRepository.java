package com.citi.hackathon_backend.volunteerInfo.repository;

import com.citi.hackathon_backend.volunteerInfo.entity.VolunteerInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
@Repository
public interface VolunteerInfoRepository extends CrudRepository<VolunteerInfo, String>{
	
}
