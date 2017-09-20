package me.microcool.doublerecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.microcool.doublerecyclerviewdemo.R;
import me.microcool.doublerecyclerviewdemo.bean.ParentInfo;

/**
 * 父层RecyclerView
 * 标题 + 内部的RecyclerView
 * Created by gaoshiwei on 2017/9/19.
 */

public class ParentInfoAdapter extends RecyclerView.Adapter<ParentInfoAdapter.ViewHolder> {

    private Context context;
    private List<ParentInfo> list;//父层列表

    public ParentInfoAdapter(Context context, List<ParentInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_data_item, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText("Item " + position);
        //把内层的RecyclerView 在 外层的onBindViewHolder
        if (holder.mRecyclerView.getAdapter() == null) {
            holder.mRecyclerView.setAdapter(new ChildInfoAdapter(context, list.get(position).getMenuList()));
        } else {
            holder.mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * static ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;//标题
        RecyclerView mRecyclerView;//子 RecyclerView

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.menu_title);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.menu_info_recyclerview);
            RecyclerView.LayoutManager manager = new GridLayoutManager(itemView.getContext(), 4);
            // 需要注意的是GridLayoutManager要设置setAutoMeasureEnabled(true)成自适应高度
            manager.setAutoMeasureEnabled(true);
            mRecyclerView.setLayoutManager(manager);
        }
    }
}
