package com.bw.ph.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bw.ph.R;
import com.bw.ph.bean.QueryShopsResult;
import com.bw.ph.utils.NetUtil;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private static final String TAG = "MyRecyclerAdapter";

    private Context mContext;
    private List<QueryShopsResult> dataList = new ArrayList<>();

    public MyRecyclerAdapter(Context mContext, List<QueryShopsResult> dataList) {
        this.mContext = mContext;
        if (dataList != null) {
            this.dataList.addAll(dataList);
        }
    }

    /**
     * 设置数据源
     */
    public void setData(List<QueryShopsResult> dataList) {
        if (null != dataList) {
            this.dataList.clear();
            this.dataList.addAll(dataList);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerl_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv1.setText(dataList.get(position).getCommodityName());
        NetUtil.getInstance().getPhpto(dataList.get(position).getMasterPic(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1;
        private ImageView img;

        private ViewHolder(View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            img=itemView.findViewById(R.id.img);
        }
    }
}
