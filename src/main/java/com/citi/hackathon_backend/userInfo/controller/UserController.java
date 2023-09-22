package com.citi.hackathon_backend.userInfo.controller;


import com.citi.hackathon_backend.userInfo.service.UserService;
import com.citi.hackathon_backend.userInfo.entity.Result;
import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public Result regist(@RequestBody UserInfo user){
        return userService.regist(user);
    }

    /*@PostMapping(value = "/regist")
    public Result regist(UserInfo user, Principal principal){
        Result result = new Result();
        if (principal!= null){
            if (userService.queryUserInfoById(principal.getName()).getAuthority().equals("admin")){
                return userService.regist(user);
            }
        }
        result.setMsg("Insufficient permissions");
        return result;

    }
*/

    @PostMapping(value = "/login")
    public Result login(@RequestBody UserInfo user){
        return userService.login(user);
    }

    @GetMapping(value = "/findUser")
    public UserInfo findUser(@RequestBody  UserInfo user){
        return userService.queryUserInfoById(user.getId());
    }

    @GetMapping(value = "/findAllUser")
    public List<UserInfo> findAllUser(){
        return userService.queryAllUser();
    }
    @PostMapping("/UserImport")
    public Result importUser(@RequestParam("file") MultipartFile file)
    {
        return userService.importUser(file);
    }


}