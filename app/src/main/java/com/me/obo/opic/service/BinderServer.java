package com.me.obo.opic.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by obo on 2017/8/19.
 * Email:obo1993@gmail.com
 */

public class BinderServer extends Binder implements IInterface {
    private IDataTranslate mDataTranslate;

    public BinderServer(IDataTranslate dataTranslate) {
        this.mDataTranslate = dataTranslate;
        attachInterface(this, IDataTranslate.DESCRIPTION);
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION:
                reply.writeString(IDataTranslate.DESCRIPTION);
                return true;
            case IDataTranslate.TRANSLATE_ADD:
                int a = data.readInt();
                int b = data.readInt();
                int result = mDataTranslate.add(a, b);
                reply.writeInt(result);
                return true;
        }
        return super.onTransact(code, data, reply, flags);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    public IDataTranslate getDataTranslate() {
        return mDataTranslate;
    }

}
