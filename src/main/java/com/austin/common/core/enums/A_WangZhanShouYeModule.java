package com.austin.common.core.enums;

/**
 * @Description:网站首页模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum A_WangZhanShouYeModule {

    WangZhanShouYe("01","网站首页"),

    ;
    private String key;
    private String value;

    A_WangZhanShouYeModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
