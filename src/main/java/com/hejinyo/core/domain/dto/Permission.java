package com.hejinyo.core.domain.dto;

import lombok.Data;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 10:48
 * @Description : 资源权限实体类，资源和权限在数据表中是分开的。
 */
@Data
public class Permission {
    private static final long serialVersionUID = 1L;
    private Integer resId; //资源编号
    private String resType;//资源类型
    private String resName;//资源名称
    private String resUrl;//资源url
    private String resIcon;//显示图标
    private String rightsName;//权限名称
    private Integer rightsId; //权限编号
    private String rightsCode;//资源权限编码（resUrl+rightsCode = ）
}
