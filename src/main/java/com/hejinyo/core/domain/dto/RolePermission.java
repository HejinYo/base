package com.hejinyo.core.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 18:28
 * @Description : 用户角色DTO类
 */
@Data
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer roleId;//角色编号
    private String roleName;//角色名称
    private String description;//角色描述
    private Integer seq;//排序号
    private Integer state; //状态  0：正常；1：锁定；-1：禁用(删除)
    private List<Permission> permissions;//角色拥有权限
}
