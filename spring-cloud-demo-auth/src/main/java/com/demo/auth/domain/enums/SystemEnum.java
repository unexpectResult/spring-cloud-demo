package com.demo.auth.domain.enums;


public enum  SystemEnum {

    SYSTEM_AUTH_SUCCESS(200,"token获取成功"),
    SYSTEM_AUTH_FAIL(500,"授权失败"),



    SYSTEM_AUTH_REFRESH_TOKEN(501,"刷新成功"),
    SYSTEM_AUTH_UNKNOWN_TOKEN(500,"未授权"),
    SYSTEM_AUTH_TOKEN_UNEXP(502,"token已过期"),
            ;

    private Integer code;
    private String  msg;

    SystemEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
