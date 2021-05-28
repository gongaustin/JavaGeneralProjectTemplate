package com.austin.common.core.enums;

/**
 * @Description:招聘专栏模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum M_ZhaoPinZhuanLanModule {

    ZhaoPinZhuanLan("14","招聘专栏"),

    ;

    private String key;
    private String value;

    M_ZhaoPinZhuanLanModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
