package com.hejinyo.core.service.impl;

import com.hejinyo.core.domain.pojo.SysUser;
import com.hejinyo.core.mapper.SysUserMapper;
import com.hejinyo.core.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByLoginName(String loginName) {
        return sysUserMapper.findByLoginName(loginName);
    }

    @Override
    public Set<String> findRoleSet(String loginName) {
        return sysUserMapper.findRoleSet(loginName);
    }

    @Override
    public Set<String> findFuncSet(String loginName) {
        return sysUserMapper.findFuncSet(loginName);
    }
}
