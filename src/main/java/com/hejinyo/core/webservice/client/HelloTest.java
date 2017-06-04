package com.hejinyo.core.webservice.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/6/3 21:58
 * @Description :
 */
public class HelloTest {

    public static void main(String[] args) {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost/webservice/HelloWorld?wsdl");
        try {
           // Object[] obj = client.invoke("sayHi", "xiao");
           // Object[] obj = client.invoke("login", new Object[]{"admin","123456"});
           // System.out.println("resp:" + obj[0]);
            Object[] obj1 = client.invoke("sum", new Object[]{1,2});
            System.out.println("resp:" + obj1[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
