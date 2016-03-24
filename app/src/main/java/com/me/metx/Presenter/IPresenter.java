package com.me.metx.Presenter;

import android.os.Bundle;

/**
 * Created by Administrator on 2016/3/18.
 */
public interface IPresenter<T> {

    Class<T> getViewClass();

    void create(Bundle savedInstanceState);

    void created(Bundle savedInstanceState);
}
