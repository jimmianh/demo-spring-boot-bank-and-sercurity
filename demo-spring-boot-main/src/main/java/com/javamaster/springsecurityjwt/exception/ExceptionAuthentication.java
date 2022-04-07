package com.javamaster.springsecurityjwt.exception;

import com.google.gson.Gson;

public class ExceptionAuthentication {
    private String statusCode;
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionAuthentication(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionHandle: {" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


    public ExceptionAuthentication() {
    }

    public String registerError(ExceptionAuthentication exceptionAuthentication) {
        exceptionAuthentication.setStatusCode("403");
        exceptionAuthentication.setMessage("Người dùng đã tồn tại");
        Gson g = new Gson();
        String response = g.toJson(exceptionAuthentication);
        return response;
    }

    public String loginError(ExceptionAuthentication exceptionAuthentication) {
        exceptionAuthentication.setStatusCode("403");
        exceptionAuthentication.setMessage("Tên đăng nhập hoặc mật khẩu sai");
        Gson g = new Gson();
        String response = g.toJson(exceptionAuthentication);
        return response;
    }
}
