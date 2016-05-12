package com.me.metx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.me.metx.Presenter.LoginPresenter;
import com.me.metx.View.ILoginView;

/**
 * Created by Administrator on 2016/3/31.
 */
public class LoginActivity extends Activity implements ILoginView {


    LoginPresenter loginPresenter;

    @Override
    public void moveToIndex() {
        Intent intent=new Intent(this,MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginPresenter=new LoginPresenter(this);

        loginPresenter.Login();

    }
}
