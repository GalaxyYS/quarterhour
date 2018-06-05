package com.bwie.test.quarterhour.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.quarterhour.inter.IBase;

import javax.inject.Inject;

public abstract   class BaseFragment<T extends  BaseContract. BasePresenter> extends Fragment implements IBase,BaseContract.BaseView {


    @Inject
    protected  T mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(getContentLayout(),  null);

        initView(view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }


}
