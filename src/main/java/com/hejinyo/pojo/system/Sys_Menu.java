package com.hejinyo.pojo.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Sys_Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    private int mid;//菜单编号
    private String mname;//菜单名字
    private String murl;//菜单地址
    private int pid;//上级菜单编号
    private int mlevel;//菜单级别
    private int sorder;//菜单显示顺序
    private String micon;//菜单图标
    private int state;//菜单状态
    private int creater;//创建人员
    private Date credate;//创建时间
    private String updateStr; //修改字段和值列表
}
