package com.austin.common.core.enums;

/**
 * @Description:医院概况模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum C_YiYuanGaiKuangModule {

    YiYuanGaiKuang("03","医院概况"),

    YiYuanJianJie("03-01","医院简介"),

    XingZhengJiaGou("03-02","行政架构"),

    YiYuanRongYu("03-03","医院荣誉"),

    YiYuanWenHua("03-04","医院文化"),

    YiYuanHuanJing("03-05","医院环境"),

    LianXiWoMen("03-06","联系我们"),




    ;
    private String key;
    private String value;

    C_YiYuanGaiKuangModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }

}
