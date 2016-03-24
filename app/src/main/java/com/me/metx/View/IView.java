package com.me.metx.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.metx.Presenter.IPresenter;

/**
 * Created by Administrator on 2016/3/18.
 */
public interface IView {
    View create(LayoutInflater inflater, ViewGroup group);

    void created();

    int getLayoutId();

    <V extends View> V findViewById(int Id);

    void BindPresenter(IPresenter presenter);

    void BindEvent();
}
