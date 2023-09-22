package com.citi.hackathon_backend.userInfo.repository;

import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface UserInfoRepository extends CrudRepository<UserInfo, String>{
	
}
