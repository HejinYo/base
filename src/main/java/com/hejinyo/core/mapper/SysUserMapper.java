package com.hejinyo.core.mapper;

import com.hejinyo.core.domain.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 14:59
 * @Description :
 */
@Repository
public interface SysUserMapper extends BaseMapper {

    /**
     * 根据登录名查找对应的用户信息
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
     * @param loginName
     * @return
     */
    Set<String> findFuncSet(String loginName);

}
