package com.hejinyo.core.common.authorization;

import com.hejinyo.core.common.utils.JsonRetrun;
import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.dto.Menu;
import com.hejinyo.core.domain.pojo.Sys_Resource;
import com.hejinyo.core.domain.pojo.Sys_User;
import com.hejinyo.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserService userService;

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
        String loginName = (String) token.getPrincipal();//从Token中获取身份信息
        ActiveUser activeUser = userService.findActiveUser(loginName);//根据登录名查询用户信息
        if (null == activeUser || -1 == activeUser.getState()) {// 如果无相关用户或已删除则返回null
            return null;
        } else if (1 == activeUser.getState()) {//是否锁定
            throw new LockedAccountException(); //抛出帐号锁定异常
        }
        //身份
        //所有菜单
        List<Menu> menus = activeUser.getMenus();
        Map<String, Object> map = new HashMap<String, Object>();
        //一级菜单
        List<Menu> menu1 = new ArrayList<Menu>();
        //二级菜单
        List<Menu> menu2 = new ArrayList<Menu>();
        //三级菜单
        List<Menu> menu3 = new ArrayList<Menu>();

        for (int i = 0; i < menus.size(); i++) {
            int level = menus.get(i).getMlevel();
            if (1 == level) {
                menu1.add(menus.get(i));
            } else if (2 == level) {
                menu2.add(menus.get(i));
            } else if (3 == level) {
                menu3.add(menus.get(i));
            }
        }
        map.put("menu1", menu1);
        map.put("menu2", menu2);
        map.put("menu3", menu3);
        String json = JsonRetrun.resultToString(0, map);
        System.out.println("==========================================");
        System.out.println(json);

        String password = activeUser.getPassword();//获取用户数据库中密码
        String salt = activeUser.getLoginSalt();//获取用户盐
        // 返回认证信息由父类AuthenticatingRealm进行认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(salt), getName());
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
