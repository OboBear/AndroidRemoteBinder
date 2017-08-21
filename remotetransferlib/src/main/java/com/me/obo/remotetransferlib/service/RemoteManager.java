package com.me.obo.remotetransferlib.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.me.obo.remotetransferlib.annotation.DataAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public class RemoteManager {
    private static Map<String, Class> classMap = new HashMap<>();
    public static void register(Class dataClass) {
        String action = RemoteManager.getAction(dataClass);
        classMap.put(action, dataClass);
    }

    public static void init(Context context) {
        ComponentName componentName = new ComponentName(context, "com.me.obo.remotetransferlib.service.RemoteService");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    public static Class getClass(String action) {
        return classMap.get(action);
    }

    public static String getAction(Class dataClass) {
        DataAction dataAction = (DataAction) dataClass.getAnnotation(DataAction.class);
        return dataAction.actionName();
    }
}
