package com.hejinyo.core.mapper;

import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.dto.RolePermission;
import com.hejinyo.core.domain.pojo.Sys_User;

import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 14:59
 * @Description :
 */
public interface UserMapper extends BaseMapper {
    ActiveUser findActiveUser(String lonigName);

    List<RolePermission> findRolePermission(String lonigName);
}
