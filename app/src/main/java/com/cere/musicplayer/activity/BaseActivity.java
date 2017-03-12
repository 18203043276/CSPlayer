package com.cere.musicplayer.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cere.musicplayer.R;
import com.cere.statusbar.StatusBar;

/**
 * Created by CeRe on 2017/3/3.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar(new StatusBar());
    }

    protected void setStatusBar(StatusBar bar){
        bar.setColorNoTranslucent(this, getResources().getColor(R.color.colorPrimaryDark));
    }
}
