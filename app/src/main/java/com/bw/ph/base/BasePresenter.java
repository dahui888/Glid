package com.bw.ph.base;

public abstract class BasePresenter<view> {

    protected view iBaseView;

    public BasePresenter() {
        initModle();
    }

    //绑定视图
    public void attachView(view iBaseView) {
        this.iBaseView = iBaseView;
    }

    //解绑视图防止activity内存泄漏
    public void detachView(){
        if (iBaseView != null) {
            iBaseView=null;
        }
    }

    //初始化modle
    public abstract void initModle();
}
