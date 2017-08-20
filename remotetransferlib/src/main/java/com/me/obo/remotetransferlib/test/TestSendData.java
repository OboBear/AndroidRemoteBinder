package com.me.obo.remotetransferlib.test;

import com.me.obo.remotetransferlib.annotation.DataAction;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

@DataAction(actionName = "RemoteData")
public class TestSendData {
    private int a = 9;
    private int b = 19;
}
