package com.bjlemon.security.util;

public class RsaUtilsTest {

    @org.junit.Test
    public void generateKey() {
        String publicKeyFilename = "D:\\Demo\\fiveClass\\day16-2\\code\\springsecurity-jwt-rsa-parent\\key_rsa.pub";
        String privateKeyFilename = "D:\\Demo\\fiveClass\\day16-2\\code\\springsecurity-jwt-rsa-parent\\key_rsa";
        try {
            RsaUtils.generateKey(publicKeyFilename, privateKeyFilename, "bjlemon", 2048);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}