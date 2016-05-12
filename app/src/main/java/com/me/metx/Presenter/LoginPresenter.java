package com.me.metx.Presenter;

import com.me.metx.IModel.ILogin;
import com.me.metx.IModel.OnLoginListener;
import com.me.metx.Model.Login;
import com.me.metx.View.ILoginView;

/**
 * Created by Administrator on 2016/3/31.
 */
public class LoginPresenter implements OnLoginListener {
    ILogin entity;
    ILoginView view;

    public LoginPresenter(ILoginView view)
    {
        this.view=view;
        this.entity=new Login();
    }

    public void Login()
    {
        this.entity.login("admin","123456",this);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
