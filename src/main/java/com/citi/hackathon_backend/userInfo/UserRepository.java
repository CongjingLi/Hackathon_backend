package com.citi.hackathon_backend.userInfo;


import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface UserRepository extends CrudRepository<UserInfo,String> {

    public UserInfo findByUserName(String userName);
    public List<UserInfo> findByOrganization(String organization);

}