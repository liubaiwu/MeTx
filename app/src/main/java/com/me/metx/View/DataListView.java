package com.me.metx.View;

import android.view.View;
import android.widget.Button;

import com.me.metx.R;

/**
 * Created by Administrator on 2016/3/18.
 */
public class DataListView extends ViewImpl {
    private Button btn_save;



    @Override
    public void created() {
        btn_save=findViewById(R.id.btn_save);
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
                Toast("测试");
            }
        });
    }
}
