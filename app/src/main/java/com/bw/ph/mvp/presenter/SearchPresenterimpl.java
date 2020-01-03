package com.bw.ph.mvp.presenter;


import com.bw.ph.base.BasePresenter;
import com.bw.ph.mvp.ISearchContract;
import com.bw.ph.mvp.modle.SearchModleImpl;

public class SearchPresenterimpl extends BasePresenter<ISearchContract.SearchView> implements ISearchContract.Presenter {

    private SearchModleImpl searchModle;

    @Override
    public void initModle() {
        searchModle = new SearchModleImpl();
    }

    @Override
    public void getData(String path) {
        searchModle.getData(path, new ISearchContract.SearchModle.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                if (iBaseView != null) {
                    iBaseView.onSuccess(json);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (iBaseView != null) {
                    iBaseView.onFailure(msg);
                }
            }
        });
    }

    //释放View接口 否则会造成activity内存泄漏
    public void onDestory(){
        if (iBaseView != null) {
            iBaseView=null;
        }
    }
}
