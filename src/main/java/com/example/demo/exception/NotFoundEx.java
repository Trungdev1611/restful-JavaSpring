package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundEx extends RuntimeException {
    private String msg = "Not Found";
    private int status = 0;
    private Object data = null;
    public NotFoundEx() {
    }

     public NotFoundEx(String msg) {
        this.msg = msg;
    }
}
