package com.citi.hackathon_backend.userInfo.repository;

import com.citi.hackathon_backend.login.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@org.socialsignin.spring.data.dynamodb.repository.EnableScan
@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, String>{
	
}
