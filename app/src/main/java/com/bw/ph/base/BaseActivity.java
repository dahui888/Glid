package com.bw.ph.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {
    //注意权限
    protected p presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayoutId());
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract int initlayoutId();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract void initData();
    protected abstract p initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
