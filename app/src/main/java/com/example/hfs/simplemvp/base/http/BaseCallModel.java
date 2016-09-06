package com.example.hfs.simplemvp.base.http;

/**
 * Created by Zhu on 2016/7/13.
 */
public class BaseCallModel<T> {
    private int status; // 0:成功;1:失败
    private String msg; //请求接口返回信息
    private T data; //JSON数据

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
