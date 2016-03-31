package com.me.metx.Common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/3/31
 * 通用适配器.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    List<T> mlist;
    Context mContext;
    int mLayoutId;

    public CommonAdapter(Context context, List<T> list,int layoutId)
    {
        this.mlist=list;
        this.mContext=context;
        this.mLayoutId=layoutId;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public T getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取ViewHolder
        CommonViewHolder viewHolder = CommonViewHolder.getViewHolder(mContext, convertView, parent,
                mLayoutId);
        // 填充数据
        FillData(viewHolder, position, getItem(position));
        // 返回convertview
        return viewHolder.getContentView();
    }

    public abstract void FillData(CommonViewHolder viewHolder,int position, T item);
}
