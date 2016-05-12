package com.me.metx.IModel;

/**
 * Created by Administrator on 2016/3/31.
 */
public interface ILogin {
    void login(String uid,String pwd,OnLoginListener onLoginListener);
}
