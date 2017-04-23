package com.basetest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hejinyo.core.common.utils.Tools;
import com.hejinyo.other.domain.Sys_Dto;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BaseTest {
    @Test
    public void test1() {
        String path = Tools.class.getClass().getResource("/").getPath();
        System.out.println(path);
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void testBaseb4() {
        /*String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString("");
        System.out.println(base64Encoded);
        System.out.println(str2);
        System.out.println(base64Encoded);*/
/*
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();
        System.out.println(md5);
        SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        randomNumberGenerator.setSeed("123".getBytes());
        String hex = randomNumberGenerator.nextBytes().toHex();
        System.out.println(new SecureRandomNumberGenerator().nextBytes().toString());*/
        String str = "admin";
        String salt = "123";
        //md5(salt+str)盐在前面
        ;
        String sjson = "{\"mid\":23,\"sys_menu\":{\"creater\":0,\"mid\":0,\"mlevel\":0,\"mname\":\"菜单\",\"pid\":0,\"sorder\":0,\"state\":88},\"test\":\"测试\",\"xid\":0}";
        Sys_Dto sys_dto = JSON.parseObject(sjson, Sys_Dto.class);
        System.out.println(sys_dto.getSys_user().getLoginName());

        Date date = new Date();
        String dates = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS");
        JSON.toJSONString(date, SerializerFeature.WriteClassName);
        System.out.println(dates);
    }

    @Test
    public void TestpathsMatch() {
        PatternMatcher pathMatcher = new AntPathMatcher();
        System.out.println( pathMatcher.matches("/test/*", "/test/excptionView"));
        System.out.println( pathMatcher.matches("", "/"));
    }
    @Test
    public void TestFaseJson(){
        String str = "{\"username\":\"asdfasd\",\"loginpw\":\"WVhOa1ptRnpaQT09NWJjYWY3ZmFmOWY4ZWI3NzQwOWJkZjEzZjlmY2M1ZDg=\",\"verifi\":\"aaaa\"}";
        JSONObject json = JSON.parseObject(str);
        String ss = json.getString("usernames");
        System.out.println(ss);
        boolean s = json.getBoolean("userndames");
        System.out.println(s);
    }

    @Test
    public void testSet(){
        Set<String> s = new HashSet<>();
        s.add("1");
        s.add("2");
        System.out.println(s.toString());
        s.add("2");
        System.out.println(s.toString());
    }

}
