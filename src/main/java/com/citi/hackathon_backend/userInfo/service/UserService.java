package com.citi.hackathon_backend.userInfo.service;

import com.citi.hackathon_backend.userInfo.entity.Result;
import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    public Result regist(UserInfo user);

    public Result login(UserInfo user);

    UserInfo queryUserInfoById(String id);

    Result importUser(@RequestParam("file") MultipartFile file);

    List<UserInfo> queryAllUser();

}
