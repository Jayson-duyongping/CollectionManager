package com.jayson.collection.util;

public class StatusCode {
    public static int CODE_SUCCESS = 1;          //访问成功

    public static int CODE_ERROR = -1;          //访问错误

    public static int CODE_ERROR_PARAMETER = -2;//参数错误

    public static int CODE_ERROR_PROGRAM = -3;  //程序异常

    public static int CODE_ERROR_NO_LOGIN_OR_TIMEOUT = -5;  //未登录或登录超时,请重新登录

    public static int CODE_ERROR_EXIST_OPERATION = 0;      //已操作
}
