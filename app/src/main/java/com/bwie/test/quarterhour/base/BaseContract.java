package com.bwie.test.quarterhour.base;

public interface BaseContract {

    interface  BaseView{
        void  showLoading();
        void  dismissLoading();
    }

    interface BasePresenter<T extends BaseView>{

        void  attachView(T view);

        void  detachView();

    }
}
