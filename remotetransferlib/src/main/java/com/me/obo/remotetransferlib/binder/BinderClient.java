package com.me.obo.remotetransferlib.binder;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.me.obo.remotetransferlib.data.RemoteData;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public class BinderClient implements RemoteData {
    public static RemoteData bind(IBinder binder) {
        IInterface iInterface = binder.queryLocalInterface(BinderService.DESCRIPTION);
        if (iInterface != null && iInterface instanceof RemoteData) {
            return (RemoteData) iInterface;
        }
        return new BinderClient(binder);
    }

    IBinder mBinder;
    public BinderClient(IBinder binder) {
        mBinder = binder;
    }

    @Override
    public String send(String action, String data) {
        Parcel sendData = Parcel.obtain();
        Parcel receiveData = Parcel.obtain();
        sendData.writeString(action);
        sendData.writeString(data);
        try {
            mBinder.transact(BinderService.TAG_DATA_TRANSFER, sendData, receiveData, 0);
            return receiveData.readString();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }
}
