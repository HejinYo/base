package com.hejinyo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 存放登录用户信息
 */
@Data
public class UserInfo implements Serializable {
    private String username; //用户名
    private String password; //密码
    private String salt;    //盐
    private String permissions; //权限
    private String role;    //角色
}
