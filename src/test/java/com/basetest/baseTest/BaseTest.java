package com.basetest.baseTest;

import com.hejinyo.common.utils.Tools;
import org.junit.Test;

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
    }

}
