package com.bjlemon.utiles;

/**
 * 自定义的异常
 */
public class ThisExeption extends  RuntimeException {

    public ThisExeption() {
        super();
    }

    public ThisExeption(String message) {
        super(message);
    }

    public ThisExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
