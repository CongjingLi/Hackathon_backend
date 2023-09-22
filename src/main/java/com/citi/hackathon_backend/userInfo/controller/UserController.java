package com.citi.hackathon_backend.userInfo.controller;


import com.citi.hackathon_backend.userInfo.service.UserService;
import com.citi.hackathon_backend.userInfo.entity.Result;
import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public Result regist(UserInfo user){
        return userService.regist(user);
    }

    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/login")
    public Result login(UserInfo user){
        return userService.login(user);
    }

    @PostMapping(value = "/findUser")
    public UserInfo findUser(UserInfo user){
        return userService.queryUserInfoById(user.getId());
    }
    @PostMapping("/UserImport")
    public Result importStudent(@RequestParam("file") MultipartFile file)
    {
        return userService.importStudent(file);
    }


}