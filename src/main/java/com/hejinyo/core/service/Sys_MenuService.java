package com.hejinyo.core.service;

import com.hejinyo.core.domain.pojo.Sys_Menu;

import java.util.List;

public interface Sys_MenuService {

    /**
     * 加载全部菜单
     *
     * @return
     */
    List<Sys_Menu> getSys_MenuList();
}
