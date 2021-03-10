package com.buct.employment.result;

import lombok.Data;

/**
 * @author JeffCar
 * @date 3/5/2021 - 5:52 PM
 */
@Data
public class CodeMsg {
    private int code;
    private String msg;

    public static CodeMsg LOGIN_FAILURE = new CodeMsg(-1, "username or password is error");
    public static CodeMsg LOGIN_SUCCESS = new CodeMsg(0, "login success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500, "Server exception");
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg FAILURE = new CodeMsg(-1, "there is something fail");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
