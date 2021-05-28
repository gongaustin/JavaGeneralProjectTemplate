package com.austin.common.core.enums;

/**
 * @Description:科研教学模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum I_KeYanJiaoXueModule {

    KeYanJiaoXue("10","科研教学"),


    ;

    private String key;
    private String value;

    I_KeYanJiaoXueModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
