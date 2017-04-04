package com.hejinyo.pojo.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sys_Dto implements Serializable {
    private Sys_Menu sys_menu;
    private Sys_User sys_user;
    private String test;
    private int mid;
    private int xid;
    private String name;
}
