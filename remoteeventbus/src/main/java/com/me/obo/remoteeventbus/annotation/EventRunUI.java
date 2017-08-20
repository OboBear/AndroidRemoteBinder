package com.me.obo.remoteeventbus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface EventRunUI {
}
