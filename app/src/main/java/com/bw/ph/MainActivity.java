package com.bw.ph;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.ph.adapter.MyRecyclerAdapter;
import com.bw.ph.base.BaseActivity;
import com.bw.ph.bean.QueryShops;
import com.bw.ph.bean.QueryShopsResult;
import com.bw.ph.mvp.ISearchContract;
import com.bw.ph.mvp.presenter.SearchPresenterimpl;
import com.bw.ph.utils.NetUtil;
import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends BaseActivity<SearchPresenterimpl> implements ISearchContract.SearchView {
    private RecyclerView rv;
    private MyRecyclerAdapter myRecyclerAdapter;

    @Override
    protected int initlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.rv);

        //判断网络
        if (!NetUtil.getInstance().NetState()){
            Toast.makeText(this, "无网络连接", Toast.LENGTH_SHORT).show();
            return;
        }


        //要给recyclerview设置布局管理器，否则不显示内容
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        //设置滑动方向
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

      String path="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E6%9D%BF%E9%9E%8B&page=1&count=10";
      presenter.getData(path);

    }

    @Override
    protected SearchPresenterimpl initPresenter() {
        return new SearchPresenterimpl();
    }


    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        QueryShops queryShops = gson.fromJson(json, QueryShops.class);
        List<QueryShopsResult> result = queryShops.getResult();
        if (myRecyclerAdapter == null) {
            myRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this,result);
            rv.setAdapter(myRecyclerAdapter);
        }
    }

    @Override
    public void onFailure(String msg){}
}
