package com.me.obo.opic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.me.obo.opic.service.aidl.IMyAidlInterface;

/**
 * Created by obo on 2017/8/19.
 * Email:obo1993@gmail.com
 */

public class MyService extends Service {
    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return new BinderServer(dataTranslate);
    }

    private IDataTranslate dataTranslate = new IDataTranslate() {
        @Override
        public int add(int a, int b) {
            return a + b;
        }
    };

}
