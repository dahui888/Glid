package com.bw.ph.mvp;


import com.bw.ph.base.IBaseView;

/**
 * 搜索契约类
 */
public interface ISearchContract {

    interface SearchView extends IBaseView {
        void onSuccess(String json);//成功
        void onFailure(String msg);//失败
    }


    interface SearchModle{
        void getData(String path, MyCallBack myCallBack);
        interface MyCallBack{
            void onSuccess(String json);//成功
            void onFailure(String msg);//失败
        }
    }


    interface Presenter{
        void getData(String path);
    }
}
