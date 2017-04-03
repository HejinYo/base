package com.basetest.baseTest;

import com.hejinyo.common.utils.JsonRetrun;
import com.hejinyo.common.utils.JsonUtil;

public class EasyTest {
    public static void main(String args[]) {
        /*Map<String, Object> jsonMap = new HashMap();
        jsonMap.put("status", "success");
        jsonMap.put("msg", "200");
        System.out.println(JsonUtil.object2Json(jsonMap));
        ;String json = "{\"msg\":\"200\",\"status\":\"success\"}";


        Map<String, Object> jsonMap1 = JsonUtil.json2Map(json);
        System.out.println(jsonMap1.get("msg"));
        //System.out.println(JsonUtil.object2Json(new JsonRetrun(400,"not found page")));
        System.out.println(new JsonRetrun(400,"not found page",new String[]{"1","2"}).result());*/

        System.out.println(JsonRetrun.result());
        System.out.println(JsonRetrun.result(1));
        System.out.println(JsonRetrun.result("成功"));
        System.out.println(JsonRetrun.result(1,"失败"));
        System.out.println(JsonRetrun.result(0,new String[]{"1","2"}));
        System.out.println(JsonRetrun.result(0,"成功",new String[]{"1","2"}));

    }

}
