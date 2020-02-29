package com.bojun.msgshowview;

import android.app.Application;

import com.bojun.floating.ViewFloat;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ViewFloat.init(this, BuildConfig.DEBUG);
    }
}
