package com.bjlemon.security.config;

import com.bjlemon.security.util.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName RsaKeyConfig.java
 * @Description TODO
 * @createTime 2020年02月20日 21:38:00
 */
@Configuration
@ConfigurationProperties("rsa.key")
public class RsaKeyConfig {
    /**
     * 密钥对路径
     */
    private String pubKeyFile;
    private String priKeyFile;
    /**
     * 密钥
     */
    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void createRsaKey() {
        try {
            this.publicKey = RsaUtils.getPublicKey(this.pubKeyFile);
            this.privateKey = RsaUtils.getPrivateKey(this.priKeyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPubKeyFile() {
        return pubKeyFile;
    }

    public void setPubKeyFile(String pubKeyFile) {
        this.pubKeyFile = pubKeyFile;
    }

    public String getPriKeyFile() {
        return priKeyFile;
    }

    public void setPriKeyFile(String priKeyFile) {
        this.priKeyFile = priKeyFile;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
