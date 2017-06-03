package com.hejinyo.core.service;

import com.hejinyo.core.domain.dto.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 15:10
 * @Description :
 */
@Service
public interface SysResourceService {

    /**
     * 根据登录名查询可用菜单
     */
    List<SysMenu> getMenuList(String loginName);
}
