package com.me.obo.opic.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by obo on 2017/8/19.
 * Email:obo1993@gmail.com
 */

public class BinderClient<T extends IDataTranslate> implements IDataTranslate {
    private IBinder mBinder;
    public BinderClient(IBinder binder) {
        mBinder = binder;
    }

    public IDataTranslate generateTranslate() {
        IInterface iInterface = mBinder.queryLocalInterface(IDataTranslate.DESCRIPTION);
        if (iInterface != null && iInterface instanceof BinderServer) {
            return ((BinderServer) iInterface).getDataTranslate();
        }
        return this;
    }

    @Override
    public int add(int a, int b) {
        Parcel data = Parcel.obtain();
        Parcel receive = Parcel.obtain();
        try {
            data.writeInt(a);
            data.writeInt(b);
            mBinder.transact(IDataTranslate.TRANSLATE_ADD, data, receive, 0);
            return receive.readInt();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
