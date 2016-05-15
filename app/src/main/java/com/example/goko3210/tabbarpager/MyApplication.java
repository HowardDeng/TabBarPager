package com.example.goko3210.tabbarpager;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by goko3210 on 16/5/14.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setSinaWeibo("2804029288","e61c01198037f8fbcfaa745d2c1ec782");
        //新浪微博 appkey appsecret
    }
}
