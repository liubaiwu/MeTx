package com.me.metx.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.me.metx.R;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/3/28.
 */
public class List  extends ViewImpl {
    com.handmark.pulltorefresh.library.PullToRefreshListView lv;
    private LinkedList<String> mListItems;

    private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler" };

    private ArrayAdapter<String> mAdapter;

    @Override
    public void created() {
        lv=findViewById(R.id.lv_list);
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        mAdapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_list_item_1, mStrings);
        lv.setAdapter(mAdapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.list;
    }

    @Override
    public void BindEvent() {

        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                if(refreshView.getCurrentMode()== PullToRefreshBase.Mode.PULL_FROM_END)
                {
                    Toast("下拉");

                }
                else if(refreshView.getCurrentMode()== PullToRefreshBase.Mode.PULL_FROM_START)
                {
                    Toast("上拉");

                }

            }
        });
    }
}
