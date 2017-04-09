package com.hejinyo.core.domain.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 14:35
 * @Description : 权限实体类
 */

@Data
public class Sys_Rights implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer rightsId; //权限编号
    private String rightsType;//权限类型
    private String rightsCode;//权限编码
    private String rightsName;//权限名称
    private Date createTime;//创建时间
    private Integer createId;//创建人员ID
}
