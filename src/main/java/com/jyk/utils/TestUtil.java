package com.jyk.utils;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author : Jing Yuankui
 * @description : 测试工具类
 * @date : Created in 2024/8/14 0:02
 */
public class TestUtil {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // AES密钥算法
        String KEY_ALGORITHM = "AES";
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(128, new SecureRandom());

    }
}
