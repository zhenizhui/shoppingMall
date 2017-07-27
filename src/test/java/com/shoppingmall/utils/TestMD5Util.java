package com.shoppingmall.utils;

import org.junit.Assert;
import org.junit.Test;

public class TestMD5Util {

    @Test
    public void testMd5Util() {
        // 密码
        String password = "123456";
        // 加密的结果
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        // 正确的结果
        String md5PasswordCheck = "12BC1B37CD60C9E80A0B1F0FFB4248A6";
        // 判断是否一致
        Assert.assertEquals(md5PasswordCheck, md5Password);
    }
}
