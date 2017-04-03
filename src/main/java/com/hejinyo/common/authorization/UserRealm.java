package com.hejinyo.common.authorization;

import com.hejinyo.pojo.system.Sys_User;
import com.hejinyo.service.system.Sys_UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户登录Realm
 *
 * @author HejinYo
 * @version 1.0
 * @email hejinyo@gmail.com
 * @since 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private Sys_UserService sys_userService;

    /**
     * 支持什么类型的token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 从token中 获取用户身份信息
        String username = (String) token.getPrincipal();
        // 拿username从数据库中查询
        Sys_User sys_user = sys_userService.findSys_UserByUser_name(username);
        // 如果查询不到则返回null
        if (null == sys_user) {
            return null;
        }
        if (-1 == sys_user.getEnabled()) {
            throw new LockedAccountException(); //帐号锁定
        }

        // 获取从数据库查询出来的用户密码
        String password = sys_user.getLogin_pass();
        String salt = sys_user.getSalt();

        // 根据用户id从数据库取出菜单
        //...先用静态数据
        List<String> menus = new ArrayList<String>();
        menus.add("商品管理");
        menus.add("用户管理");
        // 构建用户身份信息

        // 返回认证信息由父类AuthenticatingRealm进行认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sys_user, password, ByteSource.Util.bytes(salt), getName());

        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户权限
        List<String> permissions = new ArrayList<>();

        permissions.add("user:create");

        //构建shiro授权信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (String sysPermission : permissions) {
            simpleAuthorizationInfo.addStringPermission(sysPermission);
        }
        return simpleAuthorizationInfo;

    }


    /**
     * 清除当前用户所有缓存，不用传入参数，自动获取当前主题
     */
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

    /**
     * 清除指定主体的授权缓存
     *
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除指定主体的认证缓存
     *
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除指定主体的所有缓存
     *
     * @param principals
     */
    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }


    /**
     * 清除服务器中所有授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 清除服务器中所有认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }


    /**
     * 清除服务器中所有认证和授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
