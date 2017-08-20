package com.me.obo.remotetransferlib.service;

import com.me.obo.remotetransferlib.annotation.DataAction;
import com.me.obo.remotetransferlib.test.TestSendData;

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

    public static Class getClass(String action) {
        return classMap.get(action);
    }

    public static String getAction(Class dataClass) {
        DataAction dataAction = (DataAction) dataClass.getAnnotation(DataAction.class);
        return dataAction.actionName();
    }


}
