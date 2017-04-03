package com.basetest.shiro.chapter1.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class Realm02 implements Realm {

    @Override
    public String getName() {
        return "Realm01";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();  //得到用户名
        String password = new String((char[]) token.getCredentials()); //得到密码
        if (!"li".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if (!"1234".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
