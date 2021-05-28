package com.austin.common.core.enums;

/**
 * @Description:专家介绍模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum G_ZhuanJiaJieShaoModule {

    ZhuanJiaJieShao("07","专家介绍"),

    ;

    private String key;
    private String value;

    G_ZhuanJiaJieShaoModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
