package com.hejinyo.core.domain.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 14:17
 * @Description : 用户角色关联实体类
 */

@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userRoleId;//用户角色ID
    private Integer userid;//用户ID
    private Integer roleid;//角色ID
}