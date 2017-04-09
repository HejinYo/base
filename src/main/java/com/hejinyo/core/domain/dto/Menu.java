package com.hejinyo.core.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/9 18:09
 * @Description : 菜单实体类
 */
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    private int mid;//菜单编号
    private String mname;//菜单名字
    private String murl;//菜单地址
    private int pid;//上级菜单编号
    private int mlevel;//菜单级别
    private int seq;//菜单显示顺序
    private String micon;//菜单图标
    private Integer state;//状态 0：正常；1：锁定；-1：禁用(删除)
}
