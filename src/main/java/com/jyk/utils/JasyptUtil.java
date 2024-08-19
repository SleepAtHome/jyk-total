package com.jyk.utils;

import com.jyk.config.JasyptConfig;

/**
 * @author : Jing Yuankui
 * @description : jasypt工具类，用来加解密
 * @date : Created in 2024/8/19 22:44
 */
public class JasyptUtil {
    //加密方法
    public static String encrypt (String encryptStr){
        JasyptConfig jasyptStringConfig = new JasyptConfig();
        return jasyptStringConfig.jasyptStringEncryptor().encrypt(encryptStr);
    }

    //解密方法
    public static String decrypt (String decryptStr){
        JasyptConfig jasyptStringConfig = new JasyptConfig();
        return jasyptStringConfig.jasyptStringEncryptor().decrypt(decryptStr);
    }
    public static void main(String[] args) {
        String aaa=encrypt("123123");
        System.out.print("加密密文为"+aaa);

        String bbb=decrypt(aaa);
        System.out.print("解密报文为"+bbb);

    }
}
