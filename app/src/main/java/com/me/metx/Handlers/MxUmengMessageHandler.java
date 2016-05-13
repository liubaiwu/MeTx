package com.me.metx.Handlers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

/**
 * Created by Administrator on 2016/5/12.
 *  友盟通知消息监听
 */
public class MxUmengMessageHandler extends UmengMessageHandler {
    @Override
    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        Log.i("test","推送消息"+uMessage.custom);


        super.dealWithNotificationMessage(context, uMessage);
    }

    @Override
    public void dealWithCustomMessage(Context context, UMessage uMessage) {
        super.dealWithCustomMessage(context, uMessage);
        Log.i("test","自定义消息"+uMessage.custom);
    }

    @Override
    public Notification getNotification(Context context, UMessage uMessage) {
        return super.getNotification(context, uMessage);
    }
}
