package com.hejinyo.core.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回JSON结果 工具类
 *
 * @author ：HejinYo hejinyo@gmail.com
 * @version 1.0
 * @apiNote status：   结果标识：0：成功  1：失败
 * <p>
 * message：  结果信息：失败时为失败原因，成功就填写详细信息
 * <p>
 * data：     数据内容：可以发送map、list等其他所有的对象
 */
public class JsonRetrun {
    private static final int SUCCESS = 0;
    private static final int FAULT = 1;

    public JsonRetrun() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * @return Map： {"status":0}
     */
    public static Map<String, Object> result() {
        Map<String, Object> jsonMap = new HashMap(1);//存放信息的对象
        jsonMap.put("status", SUCCESS);
        return jsonMap;
    }

    /**
     * @return String：{"status":0}
     */
    public static String resultToString() {
        Map<String, Object> jsonMap = new HashMap(1);//存放信息的对象
        jsonMap.put("status", SUCCESS);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @return Map： {"status":1}
     */
    public static Map<String, Object> result(int status) {
        Map<String, Object> jsonMap = new HashMap(1);//存放信息的对象
        jsonMap.put("status", status);
        return jsonMap;
    }

    /**
     * @param status
     * @return String: {"status":1}
     */
    public static String resultToString(int status) {
        Map<String, Object> jsonMap = new HashMap(1);//存放信息的对象
        jsonMap.put("status", status);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param message
     * @return Map：{"message":"成功","status":0}
     */
    public static Map<String, Object> result(String message) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("status", SUCCESS);
        jsonMap.put("message", message);
        return jsonMap;
    }

    /**
     * @param message
     * @return String：{"message":"成功","status":0}
     */
    public static String resultToString(String message) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("status", SUCCESS);
        jsonMap.put("message", message);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @param message
     * @return Map：{"message":"失败","status":1}
     */
    public static Map<String, Object> result(int status, String message) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("message", message);
        return jsonMap;
    }

    /**
     * @param status
     * @param message
     * @return String：{"message":"失败","status":1}
     */
    public static String resultToString(int status, String message) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("message", message);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @param data
     * @return Map：{"data":["1","2"],"status":0}
     */
    public static Map<String, Object> result(int status, Object data) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("data", data);
        return jsonMap;
    }

    /**
     * @param status
     * @param data
     * @return String：{"data":["1","2"],"status":0}
     */
    public static String resultToString(int status, Object data) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("data", data);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @param message
     * @param data
     * @return Map：{"data":["1","2"],"message":"成功","status":0}
     */
    public static Map<String, Object> result(int status, String message, Object data) {
        Map<String, Object> jsonMap = new HashMap(3);//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("message", message);
        jsonMap.put("data", data);
        return jsonMap;
    }

    /**
     * @param status
     * @param message
     * @param data
     * @return String：{"data":["1","2"],"message":"成功","status":0}
     */
    public static String resultToString(int status, String message, Object data) {
        Map<String, Object> jsonMap = new HashMap(3);//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("message", message);
        jsonMap.put("data", data);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param excode
     * @param message
     * @return Map：{"errorcode":200,"message":"bad request"}
     */
    public static Map<String, Object> exception(int excode, String message) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("excode", excode);
        jsonMap.put("message", message);
        return jsonMap;
    }

    /**
     * @param excode
     * @param message
     * @return String：{"errorcode":200,"message":"bad request"}
     */
    public static String exceptionToString(int excode, String message) {
        Map<String, Object> jsonMap = new HashMap(2);//存放信息的对象
        jsonMap.put("excode", excode);
        jsonMap.put("message", message);
        return JsonUtil.object2Json(jsonMap);
    }

}
