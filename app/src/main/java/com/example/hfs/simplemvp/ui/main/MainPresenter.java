package com.example.hfs.simplemvp.ui.main;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.hfs.simplemvp.base.http.BaseCallBack;
import com.example.hfs.simplemvp.model.bean.TestBean;
import com.example.hfs.simplemvp.model.service.MainService;
import com.example.hfs.simplemvp.utils.HttpUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HFS on 2016/9/6.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;


    @Override
    public void attachUi(@NonNull MainContract.View view) {
        if (view != null) {
            mView = view;
        }

    }

    @Override
    public void detachUi() {
        mView=null;
    }

    @Override
    public void getTestData() {
        Retrofit shopRetrofit = HttpUtils.getInstance().initRetrofit();
        MainService mainService = shopRetrofit.create(MainService.class);
        /**
         * 未使用Rxjava
         */
//        Call<TestBean> testCall = mainService.getHistoryToday("2bca8643ed0b4ea68d7e12d6d1f17408","1","1","1");
//        testCall.enqueue(new BaseCallBack<TestBean>() {
//
//            @Override
//            protected void onFailure(String msg) {
//                // TODO Auto-generated method stub
//                super.onFailure(msg);
//            }
//
//            @Override
//            protected void onSuecss(Response<TestBean> response) {
//                // TODO Auto-generated method stub
//                super.onSuecss(response);
//                if (response.isSuccess()) {
//                    TestBean result = response.body();
//                    if (result != null) {
//                        List<TestBean.ResultBean> shopList = result.getResult();
//                        mView.showData(shopList);
//                    }
//                }
//            }
//
//        });

        /**
         * 使用Rxjava
         */

        mainService.getHistoryToday("2bca8643ed0b4ea68d7e12d6d1f17408","1","1","1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TestBean>() {
                    @Override
                    public void onCompleted() {
                        //TODO 完成处理
                    }

                    @Override
                    public void onError(Throwable e) {
                        //TODO 错误处理
                    }

                    @Override
                    public void onNext(TestBean testBean) {
                        mView.showData(testBean.getResult());
                    }
                });
    }
}
