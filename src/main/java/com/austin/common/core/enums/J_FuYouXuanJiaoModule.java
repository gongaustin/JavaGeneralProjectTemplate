package com.austin.common.core.enums;

/**
 * @Description:妇女宣教模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum J_FuYouXuanJiaoModule {

    FuYouXuanJiao("11","妇幼宣教"),

    ;

    private String key;
    private String value;

    J_FuYouXuanJiaoModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
