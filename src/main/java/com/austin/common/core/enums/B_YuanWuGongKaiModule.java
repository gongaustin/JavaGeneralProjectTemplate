package com.austin.common.core.enums;

/**
 * @Description:院务公开模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum B_YuanWuGongKaiModule {

    YuanWuGongKai( "02","院务公开"),

    YiLiaoJiGouGaiKuang( "02-01","医疗机构概况"),

    YiLiaoFuWuGaiKuang("02-02","医疗服务概况"),

    YiLiaoJiGouHuanJing( "02-03","医疗机构环境"),

    HangFengLianZhengJianShe( "02-04","行风廉政建设"),

    YiLiaoBaoJianZhiLiang("02-05","医疗保健质量"),

    XinXiGongKai( "02-06","信息公开"),

    ZhaoBiaoGongGao( "02-07","招标公告"),

    ZhaoBiaoJieGuoGongGao( "02-08","招标结果公告"),

    CaiGouDiaoYanGongGao( "02-09","采购调研公告"),


    ;
    private String key;
    private String value;

    B_YuanWuGongKaiModule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.key + "_" + this.value;
    }


}
