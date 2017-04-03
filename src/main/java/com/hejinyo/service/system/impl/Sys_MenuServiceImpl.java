package com.hejinyo.service.system.impl;

import com.hejinyo.mapper.system.Sys_MenuMapper;
import com.hejinyo.pojo.system.Sys_Menu;
import com.hejinyo.service.system.Sys_MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysMenuService")
public class Sys_MenuServiceImpl implements Sys_MenuService {

    @Resource(name = "sysMenuMapper")
    private Sys_MenuMapper sys_menuMapper;

    @Override
    public List<Sys_Menu> getSys_MenuList() {
        return sys_menuMapper.getSys_MenuList();
    }
}
