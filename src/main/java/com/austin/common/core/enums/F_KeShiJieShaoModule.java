package com.austin.common.core.enums;

/**
 * @Description:科室介绍模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum F_KeShiJieShaoModule {

    KeShiJieShao("06","医疗机构概况"),

    ;

    private String key;
    private String value;

    F_KeShiJieShaoModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
