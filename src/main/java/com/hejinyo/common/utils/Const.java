package com.hejinyo.common.utils;

import org.springframework.context.ApplicationContext;

/**
 * 系统常量，用户常量
 */
public class Const {
	public static final String SESSION_LANGUAGE = "SESSION_LANGUAGE";//当前系统语言
	public static final String SESSION_VERIFI_KEY = "SESSION_VERIFI_KEY";//验证码
	public static final String SESSION_IS_LOGIN = "SESSION_IS_LOGIN";//当前用户登录状态
	public static final String SESSION_USER_INFO = "SESSION_USER_INFO";//当前用户详细信息
	public static final String SESSION_USER_RIGHTS = "SESSION_USER_RIGHTS";//当前登陆用户权限
	public static final String SESSION_ROLE_RIGHTS = "SESSION_ROLE_RIGHTS";//当前登陆角色权限
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)(logincode)(loginCheckIp)|(code)).*";	//不对匹配该值的访问路径拦截（正则）
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化

}