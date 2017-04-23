package com.hejinyo.core.service;

import com.hejinyo.core.domain.pojo.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 15:06
 * @Description :
 */

@Service
public interface SysRoleService {
    /**
     * 根据登录名查询用户的角色信息
     *
     * @param loginName
     * @return
     */
    List<SysRole> findByLoginName(String loginName);
}
