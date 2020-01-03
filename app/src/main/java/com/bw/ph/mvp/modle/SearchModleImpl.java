package com.bw.ph.mvp.modle;


import com.bw.ph.mvp.ISearchContract;
import com.bw.ph.utils.NetUtil;

public class SearchModleImpl  implements ISearchContract.SearchModle {



    @Override
    public void getData(String path, final MyCallBack myCallBack) {
        NetUtil netUtil = NetUtil.getInstance();
        netUtil.doGet(path, new NetUtil.MyCallBack() {
            @Override
            public void getJsonGet(String json) {
                if (myCallBack != null) {
                    myCallBack.onSuccess(json);
                }
            }

            @Override
            public void getJsonError(String msg) {
                if (myCallBack != null) {
                    myCallBack.onFailure(msg);
                }
            }
        });

    }
}
