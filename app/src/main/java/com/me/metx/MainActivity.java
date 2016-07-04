package com.me.metx;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.me.metx.Presenter.ActivityPresenterImpl;
import com.me.metx.View.DataListView;

public class MainActivity extends ActivityPresenterImpl<DataListView> {

    @Override
    public void create(Bundle savedInstanceState) {



    }

    @Override
    public void created(Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
