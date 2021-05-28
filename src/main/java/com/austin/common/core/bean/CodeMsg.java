package com.austin.common.core.bean;

/**
 * @Description:错误代码定义
 * @Author: GongJun
 * @Date: Created in 10:01 2021/1/21
 */
public class CodeMsg {
    //通用的异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(50000, "服务端异常");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(50001, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(50002, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(50003, "手机号格式错误");
    public static CodeMsg NO_USER = new CodeMsg(50004, "用户不存在");
    public static CodeMsg USER_FORBIDDEN = new CodeMsg(50005, "用户已被禁用，请联系管理员");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(50006, "密码错误");
    public static CodeMsg OPERATE_FAIL = new CodeMsg(50007, "操作失败");
    public static CodeMsg ADMIN_DELETE_ERROR = new CodeMsg(50008, "删除失败,超级管理员用户不允许删除");
    public static CodeMsg ADMIN_UPDATE_ERROR = new CodeMsg(50009, "更新失败,超级管理员用户名不允许修改");
    public static CodeMsg USER_ADD_ERROR = new CodeMsg(50010, "添加失败,该用户已经存在");
    public static CodeMsg MODIFY_PASSWORD_ERROR = new CodeMsg(50011, "修改失败,原密码错误,如忘记,请联系管理员!");
    public static CodeMsg PARAMETER_ERROR = new CodeMsg(50012, "参数错误");
    public static CodeMsg FORBID_ACTION = new CodeMsg(50013, "禁止行为");
    public static CodeMsg OPERATE_SUCCESS = new CodeMsg(200, "操作成功");
    private int code;
    private String msg;


    //登陆模块异常....60000
    //商品模块...70000
    //订单...80000


    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    //注意需要重写toString 方法,不然到前端页面是一个对象的地址....
    @Override
    public String toString() {
        return "CodeMsg{" + "code=" + code + ", msg='" + msg + '\'' + '}';
    }

}
