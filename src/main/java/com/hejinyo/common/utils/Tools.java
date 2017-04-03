package com.hejinyo.common.utils;

import jodd.props.Props;
import jodd.util.Base64;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.io.*;
import java.util.Properties;

/**
 * 字符串，字符，日期 工具类
 *
 * @author HejinYo
 * @version 1.0
 * @email hejinyo@gmail.com
 * @since 1.0
 */
public class Tools {
    /**
     * BASE64编码
     *
     * @param str
     * @return String
     */
    public static String base64Encode(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * BASE64解码
     *
     * @param str
     * @return String
     */
    public static String base64Decoder(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decodeToString(str);
    }

    /**
     * 处理用户登录编码，获得加密密码
     *
     * @param username
     * @param password
     * @return String
     */
    public static String loginDecoder(String username, String password) {
        return base64Decoder(password).replace(username, "");
    }

    /**
     * 获得Properties 配置文件对象，用于获取属性值
     *
     * @param filePath
     * @return Props
     * @apiNote Props p = Tools.getProps("D:/java/IDEA/base/src/main/resources/properties/application.properties");
     */
    public static Props getProps(String filePath) {
        Props p = new Props();
        try {
            p.load(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 修改或添加键值对 如果key存在则修改。
     *
     * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties
     * @param key      键
     * @param value    键对应的值
     */
    public static void setProperties(String filePath, String key, String value) {
        Properties prop = new Properties();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            OutputStream fos = new FileOutputStream(filePath);
            prop.setProperty(key, value);
            //保存，并加入注释
            prop.store(fos, "Update '" + key + "' value");
            fos.close();
        } catch (IOException e) {
            System.err.println("Visit " + filePath + " for updating " + value + " value error");
        }
    }

    public static void setProperties(String filePath, String[] key, String[] value) {
        Properties prop = new Properties();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            OutputStream fos = new FileOutputStream(filePath);
            int vLen = key.length;
            for (int i = 0; i < vLen; i++) {
                prop.setProperty(key[i], value[i]);
            }
            //保存，并加入注释
            prop.store(fos, "Update Value");
            fos.close();
        } catch (IOException e) {
            System.err.println("Visit " + filePath + " for updating " + value + " value error");
        }
    }

    /**
     * 数据库密码加密
     *
     * @param password
     * @return
     * @throws IOException
     */
    public static String[] encryptDBPassword(String password) {
        String path = "D:/java/jdk/";
        String druid = "druid-1.0.16.jar com.alibaba.druid.filter.config.ConfigTools ";
        String fileInfo = "java -cp " + path + druid + password + " ;exit;";
        String pw[] = new String[3];
        try {
            Process proc = Runtime.getRuntime().exec(fileInfo);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader in = new BufferedReader(is);
            pw[1] = in.readLine();//privateKey
            pw[2] = in.readLine();//publicKey
            pw[0] = in.readLine();//encryptPassword
            in.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pw;
    }

    public static String generatePassword(String username,String password) {
        String algorithmName = "md5";
        int hashIterations = 2;

        String randomNumber = new SecureRandomNumberGenerator().nextBytes().toHex();//随机数
        System.out.println(randomNumber);

        SimpleHash hash = new SimpleHash(algorithmName, password, username+randomNumber, hashIterations);
        String encodedPassword = hash.toString();
        System.out.println(hash.toString());
        System.out.println(hash.toHex());
        return encodedPassword;
    }

    /*************************************************************/

    public static void main(String agrs[]) {
        //String password = generatePassword("admin","123456");
        System.out.println(base64Decoder("4AvVhmFLUs0KTA3Kprsdag=="));
    }
}
