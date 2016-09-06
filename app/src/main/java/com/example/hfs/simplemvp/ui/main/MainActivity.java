package com.example.hfs.simplemvp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hfs.simplemvp.R;
import com.example.hfs.simplemvp.base.BaseActivity;
import com.example.hfs.simplemvp.model.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Bind(R.id.txt_test)
    TextView mTextView;

    private MainContract.Presenter mPresenter;
    private List<TestBean.ResultBean> mResultBeanList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        attachUi();
    }

    @OnClick(R.id.btn_test)
    void onClick(View view){
        if (view.getId()==R.id.btn_test){

            mPresenter.getTestData();
        }
    }

    @Override
    public void showData(List<TestBean.ResultBean> shopList) {
        mResultBeanList.clear();
        mResultBeanList.addAll(shopList);
        mTextView.setText(mResultBeanList.get(0).getTitle());

    }

    private void attachUi() {
        mPresenter = new MainPresenter();
        mPresenter.attachUi(this);
    }
}
