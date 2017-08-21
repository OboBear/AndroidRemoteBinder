package com.me.obo.remotetransferlib.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.me.obo.remotetransferlib.binder.BinderService;
import com.me.obo.remotetransferlib.test.TestSendData;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public class RemoteService extends Service {
    private static final String TAG = "RemoteService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        RemoteManager.register(TestSendData.class);
        return new BinderService() {
            @Override
            public String parseData(String action, String dataString) {
                Class thisClass;
                if ((thisClass = RemoteManager.getClass(action)) != null) {
                    TestSendData sendData = (TestSendData) new Gson().fromJson(dataString, thisClass);
                    Log.i(TAG, "");
                }
                return "Hello";
            }
        };
    }

}
