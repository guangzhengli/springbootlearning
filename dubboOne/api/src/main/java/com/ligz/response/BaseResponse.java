package com.ligz.response;

import com.ligz.enums.StatusCode;

import java.io.Serializable;

/**
 * 基础的通信回复类
 * author:ligz
 */
public class BaseResponse<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public BaseResponse(){};

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(StatusCode statusCode) {
        code = statusCode.getCode();
        msg = statusCode.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
