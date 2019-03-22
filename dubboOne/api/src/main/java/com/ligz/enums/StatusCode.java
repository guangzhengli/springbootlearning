package com.ligz.enums;

/**
 * 请求的状态码
 * author:ligz
 */
public enum StatusCode {

    Success(200, "成功"),
    Fail(501, "失败"),
    InvalidParams(502, "无效的参数"),
    ItemIsNotExist(503, "商品不存在");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
