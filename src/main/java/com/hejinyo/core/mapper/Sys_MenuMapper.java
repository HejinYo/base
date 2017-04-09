package com.hejinyo.core.mapper;

import com.hejinyo.core.domain.pojo.Sys_Menu;
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
