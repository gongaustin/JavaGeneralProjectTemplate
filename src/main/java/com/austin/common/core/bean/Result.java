package com.austin.common.core.bean;

/**
 * @Description:输出结果的封装
 * @Author: GongJun
 * @Date: Created in 9:59 2021/1/21
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg mg) {
        if (mg == null) {
            return;
        }
        this.code = mg.getCode();
        this.msg = mg.getMsg();
    }


    /**
     * 成功时
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> message(CodeMsg mg) {
        return new Result<T>(mg);
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public T getData() {
        return data;
    }

}
