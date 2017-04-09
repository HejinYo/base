package com.hejinyo.core.web;

import com.hejinyo.core.domain.pojo.Sys_Menu;
import com.hejinyo.core.service.Sys_MenuService;
import com.hejinyo.core.common.utils.JsonRetrun;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
public class Sys_MenuController {
    @Resource(name = "sysMenuService")
    private Sys_MenuService sysMenuService;

    @RequestMapping(value = "/mutilMenu", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap<String, Object>();
        //所有菜单
        List<Sys_Menu> sys_menus = sysMenuService.getSys_MenuList();
        //一级菜单
        List<Sys_Menu> menu1 = new ArrayList<Sys_Menu>();
        //二级菜单
        List<Sys_Menu> menu2 = new ArrayList<Sys_Menu>();
        //三级菜单
        List<Sys_Menu> menu3 = new ArrayList<Sys_Menu>();

        for (int i = 0; i < sys_menus.size(); i++) {
            int menuLevel = sys_menus.get(i).getMlevel();
            if (menuLevel == 1) {
                menu1.add(sys_menus.get(i));
            } else if (menuLevel == 2) {
                menu2.add(sys_menus.get(i));
            } else if (menuLevel == 3) {
                menu3.add(sys_menus.get(i));
            }
        }
        map.put("menu1", menu1);
        map.put("menu2", menu2);
        map.put("menu3", menu3);
        return JsonRetrun.result(0, "获取成功", map);
    }

    /**
     * 编辑菜单
     *
     * @return
     */
    @RequestMapping(value = "editMenu", method = RequestMethod.GET)
    public String editMenu() {
        return "system/sys_menu";
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
        //所有菜单
        List<Sys_Menu> sys_menus = sysMenuService.getSys_MenuList();
        for (int i = 0; i < sys_menus.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", String.valueOf(sys_menus.get(i).getMid()));
            if (0 == (sys_menus.get(i).getPid())) {
                jsonObject.put("parent", "#");
            } else {
                jsonObject.put("parent", String.valueOf(sys_menus.get(i).getPid()));
            }
            jsonObject.put("text", sys_menus.get(i).getMname());
            int menuLevel = sys_menus.get(i).getMlevel();

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
