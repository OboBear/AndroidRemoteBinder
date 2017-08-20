package com.me.obo.opic.data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by obo on 2017/8/19.
 * Email:obo1993@gmail.com
 */

public class ProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy, args);
    }

}
