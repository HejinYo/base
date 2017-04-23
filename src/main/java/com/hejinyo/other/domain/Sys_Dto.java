package com.hejinyo.other.domain;

import com.hejinyo.core.domain.pojo.SysUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class Sys_Dto implements Serializable {
    private SysUser sys_user;
    private String test;
    private int mid;
    private int xid;
    private String name;
}
