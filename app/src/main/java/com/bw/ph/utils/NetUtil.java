package com.bw.ph.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.ph.R;
import com.bw.ph.context.App;


import java.util.HashMap;
import java.util.Map;


public class NetUtil {
    private static final String TAG = "NetUtil";
    private static NetUtil instance;
    public static RequestQueue requestQueue;

    private NetUtil() {
        //实例化一个请求队列
        requestQueue = Volley.newRequestQueue(App.context);
    }

    public static NetUtil getInstance() {
        if (instance == null) {
            synchronized (NetUtil.class){
                if (instance == null) {
                    instance = new NetUtil();
                }
            }
        }
        return instance;
    }


    public void doGet(String path, final MyCallBack myCallBack) {
        StringRequest get = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (myCallBack != null) {
                    myCallBack.getJsonGet(response);
                }

                Log.d(TAG, "onResponse: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (myCallBack != null) {
                    myCallBack.getJsonError(error.getMessage());
                }

                Log.d(TAG, "onErrorResponse: "+error.getMessage());
            }
        });
        // 添加到全局的请求队列
        requestQueue.add(get);
    }



    public void doPost(String path, final HashMap<String,String> params){
        StringRequest post = new StringRequest(StringRequest.Method.POST, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        requestQueue.add(post);
    }



    //Glide图片请求
    public void getPhpto(String imgpath, final ImageView imageView) {
       Glide.with(App.context)
               .load(imgpath)
               .placeholder(R.mipmap.ic_launcher)
               .error(R.mipmap.ic_launcher_round)
               .apply(RequestOptions.bitmapTransform(new CircleCrop()))
//               .apply(RequestOptions.bitmapTransform(new RoundedCorners(120)))
               .into(imageView);
    }

    //判断网络
    public boolean NetState(){
        ConnectivityManager cm= (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info!=null){
            return info.isAvailable();
        }
        return false;
    }

    //接口
    public interface MyCallBack{
        void getJsonGet(String json);//成功
        void getJsonError(String msg);//失败
    }

}
