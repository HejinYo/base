package com.hejinyo.core.common.utils;

import com.hejinyo.core.webservice.client.WebServiceClient;
import jodd.props.Props;
import jodd.util.Base64;

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
     * 获得指定Properties 配置文件对象，用于获取属性值
     *
     * @param propsFile
     * @param key
     * @return
     */
    public static String getPropsValue(String propsFile, String key) {
        Props p = new Props();
        try {
            p.load(Tools.class.getClassLoader().getResourceAsStream(propsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getValue(key);
    }

    /**
     * 获得application.properties配置文件信息，用于获取属性值
     *
     * @param key
     * @return
     */
    public static String getPropsValue(String key) {
        String propsFile = "properties/application.properties";
        Props p = new Props();
        try {
            p.load(Tools.class.getClassLoader().getResourceAsStream(propsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getValue(key);
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

    /*************************************************************/

    public static void main(String agrs[]) {
        //String password = generatePassword("admin","123456");
        //System.out.println(base64Decoder("4AvVhmFLUs0KTA3Kprsdag=="));
        //System.out.println(getPropsValue("properties/application.properties", "cxf.username"));
        System.out.println(WebServiceClient.sendClient("sum", new Object[]{1, 2}));
    }
}
