package com.bwie.test.quarterhour.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bwie.test.quarterhour.inter.IBase;

import javax.inject.Inject;

public  abstract  class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView{


    @Inject
    protected  T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentLayout());
        inject();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void initView(View view) {

    }


}
