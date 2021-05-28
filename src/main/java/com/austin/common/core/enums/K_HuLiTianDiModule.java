package com.austin.common.core.enums;

/**
 * @Description:护理天地模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum K_HuLiTianDiModule {

    HuLiTianDi("12","护理天地"),

    ;

    private String key;
    private String value;

    K_HuLiTianDiModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
