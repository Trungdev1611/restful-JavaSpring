package com.example.demo.reponse;

public class ResponseBuiderPattern {
    private final int status;
    private final String message;
    private final Object data;

    private ResponseBuiderPattern(Builder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.data = builder.data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public static class Builder {
        private int status;
        private String message;
        private Object data;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public ResponseBuiderPattern build() {
            return new ResponseBuiderPattern(this);
        }
    }
}
