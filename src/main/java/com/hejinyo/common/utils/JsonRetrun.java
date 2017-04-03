package com.hejinyo.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回JSON结果 工具类
 *
 * @author HejinYo
 * @version 1.0
 * @email hejinyo@gmail.com
 * @since 1.0
 */
public class JsonRetrun {
    private static final int SUCCESS = 0;
    private static final int FAULT = 1;

    /**
     * status;   //结果标识：0：成功  1：失败
     * message;  //结果信息：失败时为失败原因，成功就填写详细信息
     * data;     //数据内容：可以发送map、list等其他所有的对象
     */

    public JsonRetrun() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * @return {"status":0}
     */
    public static String result() {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("status", SUCCESS);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @return {"status":1}
     */
    public static String result(int status) {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("status", status);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param message
     * @return {"message":"成功","status":0}
     */
    public static String result(String message) {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("status", SUCCESS);
        jsonMap.put("message", message);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @param message
     * @return {"message":"失败","status":1}
     */
    public static String result(int status, String message) {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("message", message);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @param data
     * @return {"data":["1","2"],"status":0}
     */
    public static String result(int status, Object data) {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("data", data);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param status
     * @param message
     * @param data
     * @return {"data":["1","2"],"message":"成功","status":0}
     */
    public static String result(int status, String message, Object data) {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("status", status);
        jsonMap.put("message", message);
        jsonMap.put("data", data);
        return JsonUtil.object2Json(jsonMap);
    }

    /**
     * @param excode
     * @param message
     * @return {"errorcode":200,"message":"bad request"}
     */
    public static String exception(int excode, String message) {
        Map<String, Object> jsonMap = new HashMap();//存放信息的对象
        jsonMap.put("excode", excode);
        jsonMap.put("message", message);
        return JsonUtil.object2Json(jsonMap);
    }

}
