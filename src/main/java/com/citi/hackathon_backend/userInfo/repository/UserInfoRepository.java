package com.citi.hackathon_backend.userInfo.repository;

import com.citi.hackathon_backend.login.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, String>{
	
}
