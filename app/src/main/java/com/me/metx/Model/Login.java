package com.me.metx.Model;

import com.me.metx.IModel.ILogin;
import com.me.metx.IModel.OnLoginListener;

/**
 * Created by Administrator on 2016/3/31.
 */
public class Login implements ILogin {
    @Override
    public void login(String uid, String pwd, OnLoginListener onLoginListener) {
        if(uid.equals("admin") && pwd.equals("123456"))
        {
            onLoginListener.onSuccess();
        }
        else {
            onLoginListener.onError();
        }
    }
}
