package com.hejinyo.core.mapper;

import com.hejinyo.core.domain.dto.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 14:08
 * @Description :
 */
@Repository
public interface SysResourceMapper extends BaseMapper {

    /**
     * 根据登录名查询可用菜单
     *
     * @param loginName
     * @return
     */
    List<SysMenu> getMenuList(String loginName);
}
