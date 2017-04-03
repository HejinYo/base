package com.hejinyo.pojo.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Sys_User implements Serializable{
    private int user_id;
    private String real_name;
    private String login_name;
    private String login_pass;
    private String salt;
    private String user_phone;
    private String user_email;
    private String login_ip;
    private Date login_datatime;
    private Date logout_datetion;
    private int enabled;
    private Date create_datetime;
    private String creater;
}
