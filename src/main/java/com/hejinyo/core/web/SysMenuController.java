package com.hejinyo.core.web;

import com.hejinyo.core.common.utils.JsonRetrun;
import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.dto.SysMenu;
import com.hejinyo.core.service.SysResourceService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Resource
    private SysResourceService sysResourceService;

    /**
     * 编辑菜单
     *
     * @return
     */
    @RequestMapping(value = "editMenu", method = RequestMethod.GET)
    public String editMenu() {
        return "core/sys_menu";
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping(value = "menuTree", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object menuTree() {
        JSONArray jsonArray = new JSONArray();
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        //所有菜单
        List<SysMenu> SysMenus = sysResourceService.getMenuList(activeUser.getLoginName());
        for (int i = 0; i < SysMenus.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", String.valueOf(SysMenus.get(i).getMid()));
            if (0 == (SysMenus.get(i).getPid())) {
                jsonObject.put("parent", "#");
            } else {
                jsonObject.put("parent", String.valueOf(SysMenus.get(i).getPid()));
            }
            jsonObject.put("text", SysMenus.get(i).getMname());
            int menuLevel = SysMenus.get(i).getMlevel();

            JSONObject state = new JSONObject();
            if (menuLevel == 1) {
                state.put("opened", true);
                jsonObject.put("state", state);
            } else if (menuLevel == 2) {
                jsonObject.put("state", state);
                jsonObject.put("icon", "fa fa-folder text-primary");
            } else if (menuLevel == 3) {
                jsonObject.put("icon", "fa fa-file text-primary");
            }
            jsonArray.add(jsonObject);
        }
       /* String json = "[{\"id\":\"1\",\"parent\":\"#\",\"text\":\"Parent Node\"}," +
                "{\"id\":\"2\",\"parent\":\"1\",\"text\":\"Initially selected\",\"state\": {\"selected\": true}}," +
                "{\"id\":\"3\",\"parent\":\"1\",\"text\":\"Custom Icon\",\"icon\": \"fa fa-warning text-primary\"}," +
                "{\"id\":\"4\",\"parent\":\"1\",\"text\":\"Initially open\",\"icon\": \"fa fa-folder text-primary\", \"state\": {\"opened\": true}}," +
                "{\"id\":\"5\",\"parent\":\"4\",\"text\":\"Another node\",\"icon\": \"fa fa-file text-primary\"}]";*/
        System.out.println(jsonArray.toString());
        return jsonArray;
    }

}
