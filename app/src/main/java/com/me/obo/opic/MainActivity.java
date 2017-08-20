package com.me.obo.opic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.me.obo.opic.data.AddRemoteInterface;
import com.me.obo.opic.data.ProxyHandler;
import com.me.obo.opic.service.BinderClient;
import com.me.obo.opic.service.IDataTranslate;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentName componentName = new ComponentName(this, "com.me.obo.opic.service.MyService");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                BinderClient binderClient = new BinderClient(service);
                IDataTranslate iDataTranslate = binderClient.generateTranslate();
                int result = iDataTranslate.add(1, 2);
                Log.i("", "" + result);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);

        Method[] methods = AddRemoteInterface.class.getDeclaredMethods();
        Method[] methods1 = AddRemoteInterface.class.getMethods();
        Class []pare = methods[0].getParameterTypes();
        String name = methods[0].getName();

        AddRemoteInterface addRemoteInterface = (AddRemoteInterface) Proxy.newProxyInstance(getClassLoader(), new Class[]{AddRemoteInterface.class}, new ProxyHandler());
//        addRemoteInterface.add(2, 3);
        addRemoteInterface.asBinder();

        Log.i("","");

    }

}
