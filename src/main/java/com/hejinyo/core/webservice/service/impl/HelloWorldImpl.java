package com.hejinyo.core.webservice.service.impl;

import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.webservice.service.HelloWorld;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.jws.WebService;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/6/3 20:42
 * @Description :
 */
@WebService(endpointInterface = "com.hejinyo.core.webservice.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    @Override
    public String sum(int x, int y) {
        System.out.println("sum called");
        return "sum " + (x + y);
    }

    @Override
    public String login(String username, String password) {

        System.out.println("login called");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //4、登录，即身份验证
            subject.login(token);
            if (subject.isAuthenticated()) {
                ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
                return "success"+activeUser.getLoginPwd();
            } else {
                return "faild";
            }
        } catch (AuthenticationException e) {
            //5、身份验证失败
            return "faild";
        }

    }
}