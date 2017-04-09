package com.basetest.baseTest;

import com.hejinyo.core.common.utils.Tools;
import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.dto.Menu;
import com.hejinyo.core.domain.dto.Permission;
import com.hejinyo.core.domain.dto.RolePermission;
import com.hejinyo.core.domain.pojo.Sys_Resource;
import com.hejinyo.core.domain.pojo.Sys_User;
import com.hejinyo.core.mapper.UserMapper;
import com.hejinyo.other.service.ITableIpService;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"/spring/spring-base.xml"}) //加载配置文件
public class SpringBaseTest {
    //------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
    //这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
    //@Transactional
    //这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
    //@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
    //------------
    @Resource(name = "tableIpServiceImpl")
    ITableIpService service;

    @Resource
    UserMapper userMapper;

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void printTable() {
        System.out.println("====================" + service.getRowCount() + "====================");
    }

    @Test   //标明是测试方法
    public void test1() {
        String path = Tools.class.getClass().getResource("/").getPath();
        System.out.println("===========================" + path);
    }

    @Test
    public void testUser() {
       /* Sys_User sys_user = new Sys_User();
        sys_user.setUserName("hejinyo");
        sys_user.setLoginName("hejinyo");
        sys_user.setPassword("00b3187384f2708025074f28764a4a30");
        sys_user.setLoginSalt("salt");
        userMapper.add(sys_user);*/
        /*ActiveUser activeUser = userMapper.findActiveUser("admin");
        List<Menu> menus = activeUser.getMenus();
        for(int i = 0; i< menus.size(); i++){
            System.out.println(menus.get(i).getMid()+menus.get(i).getMurl());
        }*/

        List<RolePermission> rolePermissions = userMapper.findRolePermission("admin");
        for(int i=0; i< rolePermissions.size();i++){
            System.out.println(i+"角色："+rolePermissions.get(i).getRoleName());
            List<Permission> permission = rolePermissions.get(i).getPermissions();
            for(int j=0; j<permission.size();j++){
                System.out.println(rolePermissions.get(i).getRoleName()+"："+permission.get(j).getRightsCode());
            }


        }
    }


}

