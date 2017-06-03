package com.hejinyo.core.domain.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 14:19
 * @Description : 角色授权关联实体类，授权的是资源权限（两张表）
 */

@Data
public class Sys_Role_Resource implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer roleResId;//角色授权编号
    private Integer roleId;//角色编号
    private Integer resId;//资源编号
}
