package com.hejinyo.service.system;

import com.hejinyo.pojo.system.Sys_User;

public interface Sys_UserService {

    /**
     * 根据用户名查找一个用户信息
     *
     * @param user_name
     * @return
     */
    Sys_User findSys_UserByUser_name(String user_name);

}
