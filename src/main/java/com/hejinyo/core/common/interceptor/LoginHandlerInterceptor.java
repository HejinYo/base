package com.hejinyo.core.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String path = request.getServletPath();//获取请求路径*/
        HttpSession session = request.getSession();
       /* if ((session.getAttribute(Const.SESSION_USER_INFO)) == null) {
            System.out.println("未登录拦截，请求路径:" + request.getServletPath());
            response.sendRedirect(request.getContextPath() + "/to_login");
            return false;
        } else {
            return true;
        }*/
        return true;
    }
}
