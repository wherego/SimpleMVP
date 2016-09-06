package com.example.hfs.simplemvp.ui.main;

import com.example.hfs.simplemvp.base.BasePresenter;
import com.example.hfs.simplemvp.base.BaseView;
import com.example.hfs.simplemvp.model.bean.TestBean;

import java.util.List;

/**
 * Created by HFS on 2016/9/6.
 */
public interface MainContract {
    interface View extends BaseView {


        void showData(List<TestBean.ResultBean> shopList);
    }

    interface Presenter extends BasePresenter<MainContract.View> {


        void getTestData();
    }
}
