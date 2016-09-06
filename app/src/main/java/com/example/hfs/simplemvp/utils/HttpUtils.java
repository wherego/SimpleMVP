package com.example.hfs.simplemvp.utils;



import com.example.hfs.simplemvp.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static final int DEFAULT_TIMEOUT = 15;

    private static HttpUtils mHttpUtils;
    //构造方法私有
    private HttpUtils() {

    }

    //获取单例
    public static HttpUtils getInstance(){
        if(mHttpUtils==null){
           synchronized (HttpUtils.class){
               if(mHttpUtils==null){
                   mHttpUtils = new HttpUtils();
               }
           }
        }
        return mHttpUtils;
    }

    /**
     * 未使用Rxjava
     * @return
     */
//    public Retrofit initRetrofit(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(Constant.baseUrl)
//                .build();
//
//        return retrofit;
//    }


    /**
     * 使用Rxjava
     */
        public Retrofit initRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//就多加了这句话
                .baseUrl(Constant.baseUrl)
                .build();

        return retrofit;
    }


}
