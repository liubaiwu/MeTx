package com.me.metx.View;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import com.me.metx.R;
import com.me.metx.Utils.StringUtils;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/3/18.
 */
public class DataListView extends ViewImpl {
    private Button btn_save;

    private TextView tv;

    @Override
    public void created() {
        btn_save=findViewById(R.id.btn_save);
        tv=findViewById(R.id.tv_html);
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
    }
}
