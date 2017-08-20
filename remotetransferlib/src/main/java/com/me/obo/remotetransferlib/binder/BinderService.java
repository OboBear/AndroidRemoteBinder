package com.me.obo.remotetransferlib.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public abstract class BinderService extends Binder implements IInterface {

    public static final String DESCRIPTION = "com.me.obo.remotetransferlib.binder.BinderService";
    public static final int TAG_DATA_TRANSFER = 1;

    public BinderService() {
        attachInterface(this, DESCRIPTION);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        String action = data.readString();
        String dataString = data.readString();
        reply.writeString(parseData(action, dataString));
        return super.onTransact(code, data, reply, flags);
    }

    public abstract String parseData(String action, String dataString);
}
