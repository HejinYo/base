package com.hejinyo.mapper.system;

import com.hejinyo.mapper.BaseMapper;
import com.hejinyo.pojo.system.Sys_Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysMenuMapper")
public interface Sys_MenuMapper extends BaseMapper {

    /**
     * 加载全部菜单
     *
     * @return
     */
    List<Sys_Menu> getSys_MenuList();
}
