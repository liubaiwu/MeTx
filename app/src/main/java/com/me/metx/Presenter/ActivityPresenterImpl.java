package com.me.metx.Presenter;

import android.app.Activity;
import android.os.Bundle;

import com.me.metx.Common.GenericHelper;
import com.me.metx.View.IView;

/**
 * Created by Administrator on 2016/3/18.
 */
public class ActivityPresenterImpl<T extends IView> extends Activity implements IPresenter<T> {

    T mView;

    @Override
    public Class<T> getViewClass() {
        return GenericHelper.getViewClass(getClass());
    }

    @Override
    public void create(Bundle savedInstanceState) {

    }

    @Override
    public void created(Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create(savedInstanceState);
        try {
            mView=getViewClass().newInstance();
            mView.BindPresenter(this);
            setContentView(mView.create(getLayoutInflater(),null));
            mView.BindEvent();
            created(savedInstanceState);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
