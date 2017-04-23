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
     * 根据角色ID查询权限信息
     */
    List<SysMenu> getMenuByLoginName();
}
