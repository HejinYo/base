package com.hejinyo.core.domain.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 14:30
 * @Description : 资源权限关联实体类
 */

@Data
public class Sys_Resource_Rights implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer resourceRightsId;//资源权限编号
    private Integer resId;//资源编号
    private Integer rightsId;//权限编号
}
