package com.hejinyo.core.service;

import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.po.Sys_User;

import java.util.Set;

public interface SysUserService {

    /**
     * 执行登录，查询用户登录信息
     *
     * @param loginName
     * @return
     */
    ActiveUser findLoginInfo(String loginName);

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
