package com.me.metx.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.me.metx.Presenter.IPresenter;

/**
 * Created by Administrator on 2016/3/18.
 */
public abstract class ViewImpl implements IView {
    protected View mRootView;
    protected IPresenter presenter;
    protected Context mContext;

    @Override
    public View create(LayoutInflater inflater, ViewGroup group) {
        mRootView=inflater.inflate(getLayoutId(),null);
        mContext=mRootView.getContext();
        created();
        return mRootView;
    }

    @Override
    public void created() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void BindEvent() {

    }

    @Override
    public void BindPresenter(IPresenter presenter) {
        this.presenter=presenter;
    }

    /**
     * 获取控件
     * @param Id 控件Id
     * @param <V> 泛型类型
     * @return
     */
    @Override
    public <V extends View> V findViewById(int Id) {
        return (V) mRootView.findViewById(Id);
    }

    /**
     * toast提示
     * @param msg
     */
    public void Toast(String msg){

        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();

    }
}
