package com.hejinyo.core.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 18:09
 * @Description : 菜单实体类
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer mid;//菜单编号
    private String redCode;//资源编码
    private String mname;//菜单名字
    private String murl;//菜单地址
    private Integer pid;//上级菜单编号
    private Integer mlevel;//菜单级别
    private Integer seq;//菜单显示顺序
    private String micon;//菜单图标
}
