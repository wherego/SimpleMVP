package com.example.hfs.simplemvp.model.service;

import com.example.hfs.simplemvp.model.bean.TestBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HFS on 2016/9/6.
 */
public interface MainService {

    /**
     * 未使用Rxjava
     * 获取历史上的今天 从阿凡达数据请求
     * @param key key
     * @param yue 月
     * @param ri 日
     * @param type 类型
     * @return
     */
//    @GET("HistoryToday/LookUp?")
//    Call<TestBean> getHistoryToday(@Query("key") String key, @Query("yue") String yue, @Query("ri") String ri, @Query("type") String type);


    /**
     * 使用Rxjava HttpUtils中也要进行修改 MainPresenter类中也要响应进行修改
     */
    @GET("HistoryToday/LookUp?")
    Observable<TestBean> getHistoryToday(@Query("key") String key, @Query("yue") String yue, @Query("ri") String ri, @Query("type") String type);


}
