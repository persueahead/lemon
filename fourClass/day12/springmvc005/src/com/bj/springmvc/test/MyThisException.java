package com.bj.springmvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "除数不能为0。。。。。。。。")
public class MyThisException extends RuntimeException{
    public MyThisException() {
        super();
    }

    public MyThisException(String message) {
        super(message);
    }

    public MyThisException(Throwable cause) {
        super(cause);
    }
}
