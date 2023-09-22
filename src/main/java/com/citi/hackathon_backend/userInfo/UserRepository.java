package com.citi.hackathon_backend.userInfo;


import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface UserRepository extends CrudRepository<UserInfo,String> {


}