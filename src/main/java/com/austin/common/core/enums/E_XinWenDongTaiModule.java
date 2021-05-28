package com.austin.common.core.enums;

/**
 * @Description:新闻动态模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum E_XinWenDongTaiModule {

    XinWenDongTai("05","新闻动态"),

    ;
    private String key;
    private String value;

    E_XinWenDongTaiModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
