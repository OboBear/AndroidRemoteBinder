package com.me.obo.remotetransferlib.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.me.obo.remotetransferlib.R;
import com.me.obo.remotetransferlib.binder.BinderClient;
import com.me.obo.remotetransferlib.data.RemoteData;
import com.me.obo.remotetransferlib.service.RemoteManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentName componentName = new ComponentName(this, "com.me.obo.remotetransferlib.service.RemoteService");
        Intent serviceIntent = new Intent();
        serviceIntent.setComponent(componentName);
        bindService(serviceIntent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                RemoteData remoteData = BinderClient.bind(iBinder);
                String receiveString = remoteData.send(RemoteManager.getAction(TestSendData.class), new Gson().toJson(new TestSendData()));
                Log.i("","");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);


    }
}
