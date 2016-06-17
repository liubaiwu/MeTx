package com.me.metx.View;

import android.content.Intent;
import android.graphics.Color;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import com.me.metx.Handlers.MxUmengMessageHandler;
import com.me.metx.MainList;
import com.me.metx.R;
import com.me.metx.Test;
import com.me.metx.Utils.ConvertUtils;
import com.me.metx.Utils.StringUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/3/18.
 */
public class DataListView extends ViewImpl {
    private Button btn_save,btn_list,btn_ref;

    private TextView tv;

    private ImageView imgs;
    com.handmark.pulltorefresh.library.PullToRefreshScrollView sv;

    @Override
    public void created() {

        PushAgent mPushAgent = PushAgent.getInstance(mContext);
        mPushAgent.enable();

        PushAgent.getInstance(mContext).onAppStart();

        String device_token = UmengRegistrar.getRegistrationId(mContext);

        mPushAgent.setMessageHandler(new MxUmengMessageHandler());

        Log.i("test",device_token);

        btn_save=findViewById(R.id.btn_save);
        btn_list=findViewById(R.id.btn_list);
        btn_ref=findViewById(R.id.btn_ref);
        tv=findViewById(R.id.tv_html);
        sv=findViewById(R.id.sv_test);

        imgs=findViewById(R.id.imgs);

        String internetUrl = "http://i.imgur.com/idojSYm.png";
        Glide.with(mContext).load(internetUrl).into(imgs);

        SweetAlertDialog pDialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.show();

         TrafficStats.getTotalRxBytes();




    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void BindEvent() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AsyncHttpClient httpClient=new AsyncHttpClient();
                httpClient.get("http://www.baidu.com", new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {
                            String s=new String(responseBody,"utf-8");
                            tv.setText(s);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });

                Toast("测试");
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MainList.class));
            }
        });

        btn_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, Test.class));
            }
        });

        sv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                new GetData().execute("");
            }
        });
    }

    public class GetData extends AsyncTask<String,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            sv.onRefreshComplete();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
