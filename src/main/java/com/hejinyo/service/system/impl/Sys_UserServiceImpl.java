package com.hejinyo.service.system.impl;

import com.hejinyo.mapper.system.Sys_UserMapper;
import com.hejinyo.pojo.system.Sys_User;
import com.hejinyo.service.system.Sys_UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Sys_UserServiceImpl implements Sys_UserService {

    @Resource
    private Sys_UserMapper sys_userMapper;

    @Override
    public Sys_User findSys_UserByUser_name(String user_name) {
        return sys_userMapper.findSys_UserByUser_name(user_name);
    }
}
