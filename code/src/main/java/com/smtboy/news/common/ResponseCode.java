package com.smtboy.news.common;

public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_AUGUMENT(2,"ILLEGAL_AUGUMENT");

    private final int code;
    private final String desc;//描述

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
