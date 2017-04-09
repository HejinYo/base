package com.hejinyo.core.service.impl;

import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.pojo.Sys_User;
import com.hejinyo.core.mapper.UserMapper;
import com.hejinyo.core.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ActiveUser findActiveUser(String loginName) {
        return userMapper.findActiveUser(loginName);
    }
}
