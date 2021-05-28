package com.austin.common.core.enums;

/**
 * @Description:就诊指南模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum H_JiuZhenZhiNanModule {

    JiuZhenZhiNan("08","就诊指南"),

    ;

    private String key;
    private String value;

    H_JiuZhenZhiNanModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
