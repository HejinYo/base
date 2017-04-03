package com.hejinyo.mapper.system;

import com.hejinyo.mapper.BaseMapper;
import com.hejinyo.pojo.system.Sys_User;
import org.springframework.stereotype.Repository;

@Repository
public interface Sys_UserMapper extends BaseMapper {

    /**
     * 根据用户名查找一个用户信息
     *
     * @param user_name
     * @return
     */
    Sys_User findSys_UserByUser_name(String user_name);

}
