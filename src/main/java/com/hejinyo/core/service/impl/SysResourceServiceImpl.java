package com.hejinyo.core.service.impl;

import com.hejinyo.core.domain.dto.SysMenu;
import com.hejinyo.core.domain.pojo.SysUser;
import com.hejinyo.core.mapper.SysResourceMapper;
import com.hejinyo.core.service.SysResourceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 15:11
 * @Description :
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysMenu> getMenuByLoginName() {
        Subject subject = SecurityUtils.getSubject();
        SysUser activeUser = (SysUser) subject.getPrincipal();
        return sysResourceMapper.getMenuByLoginName(activeUser.getLoginName());
    }
}
