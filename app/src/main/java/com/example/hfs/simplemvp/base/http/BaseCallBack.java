package com.example.hfs.simplemvp.base.http;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 自定义Retrofit Callback
 */
public abstract class BaseCallBack<T extends BaseCallModel> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.raw().code() == 200) {
            Log.i("responseString", "------" + response.message());
            onSuecss(response);
        } else {
            onFailure(call, new RuntimeException("错误信息" + response.raw().toString()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
            onNextErrxor();

        } else if (t instanceof ConnectException) {
            onNextErrxor();

        } else if (t instanceof RuntimeException) {
            onSysError();

        }
        onFailure(t.getMessage());
    }

    /**
     * 输出异常信息
     */
    protected void onSysError() {

    }

    /**
     * 请求失败(获取请求失败信息)
     *
     * @param msg 请求失败信息
     */
    protected void onFailure(String msg) {

    }

    /**
     * 抛出异常
     */
    protected void onNextErrxor() {

    }

    /**
     * 请求成功返回数据
     *
     * @param response response.body()即返回数据所对应实体类
     */
    protected void onSuecss(Response<T> response) {

    }
}
