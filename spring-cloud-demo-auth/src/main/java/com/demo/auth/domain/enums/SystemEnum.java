package com.demo.auth.domain.enums;


import com.demo.commons.domain.system.Commons;

public enum  SystemEnum {

    SYSTEM_AUTH_SUCCESS(200,"token获取成功"),
    SYSTEM_AUTH_REFRESH_TOKEN_SUCCESS(201, "token刷新成功"),
    SYSTEM_AUTH_FAIL(500,"授权失败"),



    SYSTEM_NOT_FOUND(404,"URL没找到"),
    SYSTEM_AUTH_UNKNOWN_TOKEN(500,"未授权"),
    SYSTEM_AUTH_TOKEN_UNEXP(502,"token已过期"),
    SYSTEM_USER_NOT_FOUND(503, Commons.USER_NOT_FOUND),
    SYSTEM_USER_PASSWORD_ERROR(504,Commons.USER_PASSWORD_ERROR),
    SYSTEM_GRANT_TYPE_ERROR(505,"grantTypeError");

    private Integer code;
    private String  msg;
    SystemEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
