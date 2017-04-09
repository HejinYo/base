package com.hejinyo.core.service;

import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.pojo.Sys_User;

public interface UserService {

    /**
     * 根据用户名查找一个用户信息
     *
     * @param loginName
     * @return
     */
    ActiveUser findActiveUser(String loginName);

}
