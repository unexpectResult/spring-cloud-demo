package com.demo.commons.util;

import com.demo.commons.domain.enums.SystemEnum;
import com.demo.commons.domain.system.Result;

public class ResultUtils {

    /**
     * 基础返回对象
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result normalResult(Integer code, String msg, Object data){
        return new Result(code,msg,data);
    }

    public static Result success(Object data){
        return normalResult(SystemEnum.SYSTEM_AUTH_SUCCESS.getCode(), SystemEnum.SYSTEM_AUTH_SUCCESS.getMsg(),data);
    };

    public static Result fail(Object data){
        return normalResult(SystemEnum.SYSTEM_AUTH_FAIL.getCode(),SystemEnum.SYSTEM_AUTH_FAIL.getMsg(),data);
    };

    public static Result notFound(){
        return normalResult(SystemEnum.SYSTEM_NOT_FOUND.getCode(),SystemEnum.SYSTEM_NOT_FOUND.getMsg(),null);
    };

    public static Result grantTypeError(){
        return normalResult(SystemEnum.SYSTEM_GRANT_TYPE_ERROR.getCode(),SystemEnum.SYSTEM_GRANT_TYPE_ERROR.getMsg(),null);
    };

}
