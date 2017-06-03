package com.hejinyo.core.mapper;

import com.hejinyo.core.domain.po.Sys_Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 12:44
 * @Description :
 */
@Repository
public interface SysRoleMapper extends BaseMapper {

    /**
     * 根据登录名查询用户的角色信息
     *
     * @param loginName
     * @return
     */
    List<Sys_Role> findByLoginName(String loginName);

}
