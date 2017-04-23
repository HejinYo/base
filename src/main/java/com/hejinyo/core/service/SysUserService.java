package com.hejinyo.core.service;

import com.hejinyo.core.domain.pojo.SysUser;

import java.util.Set;

public interface SysUserService {

    /**
     * 根据登录名查找一个用户信息
     *
     * @param loginName
     * @return
     */
    SysUser findByLoginName(String loginName);

    /**
     * 据登录名查找对应的角色编码字符串
     *
     * @param loginName
     * @return
     */
    Set<String> findRoleSet(String loginName);

    /**
     * 根据登录名查找对应的权限编码字符串
     *
     * @param loginName
     * @return
     */
    Set<String> findFuncSet(String loginName);

}
