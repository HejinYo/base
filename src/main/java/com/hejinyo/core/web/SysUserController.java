package com.hejinyo.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/5/13 22:44
 * @Description :
 */

@Controller
@RequestMapping("/user")
public class SysUserController {

    /**
     * 用户管理页面
     * @return
     */
    @RequestMapping("/manager")
    public String SysUser() {
        return "core/sysUser";
    }
}
