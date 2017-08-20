package com.me.obo.remoteeventbus;

import com.me.obo.remoteeventbus.annotation.EventRunBack;

import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public class RemoteEventBus {

    public static Map<Class, Map<Method, Object>> weakMap = new WeakHashMap<>();

    public static class Pare {
        public Method method;
        public WeakReference<Object> object;
    }

    public static void register(Object object) {
        Method []methods = object.getClass().getMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(EventRunBack.class);
            if (annotation != null) {

            }
        }
//        weakMap.put();
    }

    public static void unregister(Object object) {

    }

    public static void sendEvent() {

    }

}
