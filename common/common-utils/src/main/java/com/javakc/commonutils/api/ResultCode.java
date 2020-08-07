package com.javakc.commonutils.api;

public interface ResultCode {
    /**
     * 调用成功
     */
    public static Integer SUCCESS = 20000;

    /**
     * 服务不可用
     */
    public static Integer ERROR = 20001;
    /**
     * 参数错误
     */
    public static Integer ERROR_PARAM = 20002;
}
