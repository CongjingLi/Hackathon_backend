package com.citi.hackathon_backend.userInfo.service.impl;


import com.citi.hackathon_backend.userInfo.service.UserService;
import com.citi.hackathon_backend.userInfo.UserRepository;
import com.citi.hackathon_backend.userInfo.entity.Result;
import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Result regist(UserInfo user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            UserInfo existUser = (UserInfo) userRepository.findById(user.getId()).get();
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户ID已存在");

            }else{
                userRepository.save(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result login(UserInfo user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            UserInfo logUser= (UserInfo) userRepository.findById(user.getId()).get();
            if(logUser.getId() == null||!(user.getPassword().equals(logUser.getPassword()))){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(logUser.getId());
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public Result importStudent(@RequestParam("file") MultipartFile file)
    {
        Result result = new Result();
        List<UserInfo> userInfos = null;
        try
        {
            userInfos = UserDataUtil.excelToUsers(file.getInputStream());
            if (userInfos == null)
            {
                System.out.println("文件没有数据或者用户名重复");
                result.setMsg("批量注册失败，文件没有数据或者用户名重复");
                return result;
            }

            System.out.println("从execl文件读取到得数据信息："+userInfos);

            // 判断导入的用户信息的用户名是否与数据库中的用户名重复
            for (int i = 0; i < userInfos.size(); i++)
            {

                UserInfo userInfo = (UserInfo) userRepository.findById(userInfos.get(i).getId()).get();
                if (userInfo != null)
                {
                    result.setMsg("批量注册失败，用户名重复"+userInfo.getUserName()+"】与数据库中的用户名重名");
                    return result;
                }
            }

            // 批量插入学生信息
            for (int i = 0; i < userInfos.size(); i++)
            {
                userRepository.save(userInfos.get(i));
            }

        } catch (Exception e)
        {
            System.out.println("文件导入异常");
            result.setMsg("批量注册失败，文件信息不规范");
            return result;
        }

        result.setMsg("批量注册成功");
        return result;
    }
    @Override
    public UserInfo queryUserInfoById(String id) {
        return (UserInfo) userRepository.findById(id).get();
    }
}