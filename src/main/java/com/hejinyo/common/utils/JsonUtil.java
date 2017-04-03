package com.hejinyo.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class JsonUtil {
    private JsonUtil() {
        throw new Error("工具类不能实例化！");
    }

    public static Map<String, Object> json2Map(String json) {
        return (Map) JSON.parse(json);
    }

    public static <T> T json2Object(String json, Class<T> c) {
        return JSON.parseObject(json, c);
    }

    public static String warpJson2ListJson(String json) {
        String jsonStr = json;
        if (!StringUtil.isNullOrBlank(json) && !json.startsWith("[")) {
            jsonStr = "[" + json + "]";
        }

        return jsonStr;
    }

    public static <T> List<T> json2List(String json, Class<T> c) {
        String jsonStr = json;
        if (!StringUtil.isNullOrBlank(json)) {
            if (!json.startsWith("[")) {
                jsonStr = "[" + json + "]";
            }

            return JSON.parseArray(jsonStr, c);
        } else {
            return new ArrayList();
        }
    }

    public static String object2Json(Object entity) {
        return JSON.toJSONString(entity);
    }
}