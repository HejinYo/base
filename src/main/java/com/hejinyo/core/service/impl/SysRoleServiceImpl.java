package com.hejinyo.core.service.impl;

import com.hejinyo.core.domain.pojo.SysRole;
import com.hejinyo.core.domain.pojo.SysUser;
import com.hejinyo.core.mapper.SysRoleMapper;
import com.hejinyo.core.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 15:07
 * @Description :
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findByLoginName(String loginName) {
        return sysRoleMapper.findByLoginName(loginName);
    }
}
