package com.bjlemon.security.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CustomPasswordEncoder.java
 * @Description TODO
 * @createTime 2020年02月18日 22:08:00
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
