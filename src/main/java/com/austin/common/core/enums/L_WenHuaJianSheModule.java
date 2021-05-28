package com.austin.common.core.enums;

/**
 * @Description:文化建设模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum L_WenHuaJianSheModule {

    WenHuaJianShe("13","文化建设"),

    ;

    private String key;
    private String value;

    L_WenHuaJianSheModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }
}
