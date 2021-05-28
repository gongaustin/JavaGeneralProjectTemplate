package com.austin.common.core.enums;

/**
 * @Description:分院区模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum D_FenYuanQuModule {

    FenYuanQu("04","分院区"),

    LaoYuanQu("04-01","老院区"),

    XinYuanQu("04-02","新院区"),


    ;
    private String key;
    private String value;

    D_FenYuanQuModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
