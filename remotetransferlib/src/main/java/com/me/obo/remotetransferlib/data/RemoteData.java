package com.me.obo.remotetransferlib.data;

import com.me.obo.remotetransferlib.annotation.DataAction;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public interface RemoteData {
    public String send(String action, String data);
}
