package io.reactivex.remote.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * @hide
 *
 * Wraps a {@link RemoteEventManager} implementation and expose it as a remote {@link IBinder}
 * <p>
 * Autogenerated by <a href="https://bit.ly/Remoter">Remoter</a>
 *
 * @see RemoteEventManager_Proxy
 */
public class RemoteEventManager_Stub extends Binder {
    private static final String DESCRIPTOR = "polycom.conference.RemoteEventManager";

    private static final int TRANSACTION_subscribe_0 = android.os.IBinder.FIRST_CALL_TRANSACTION + 0;

    private static final int TRANSACTION_unsubscribe_1 = android.os.IBinder.FIRST_CALL_TRANSACTION + 1;

    private static final int TRANSACTION_close_2 = android.os.IBinder.FIRST_CALL_TRANSACTION + 2;


    private RemoteEventManager serviceImpl;

    /**
     * Initialize this {@link RemoteEventManager_Stub} with the given {@link RemoteEventManager} implementation
     *
     * @param serviceImpl An implementation of {@link RemoteEventManager}
     */
    public RemoteEventManager_Stub(RemoteEventManager serviceImpl) {
        this.serviceImpl = serviceImpl;
        this.attachInterface(new IInterface() {
                                 public IBinder asBinder() {
                                     return RemoteEventManager_Stub.this;
                                 }
                             }
                , DESCRIPTOR);
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        try {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_subscribe_0: {
                    data.enforceInterface(DESCRIPTOR);
                    RemoteEventListener arg_stb_0;
                    arg_stb_0 = new RemoteEventListener_Proxy(data.readStrongBinder());
                    serviceImpl.subscribe(arg_stb_0);
                    return true;
                }
                case TRANSACTION_unsubscribe_1: {
                    data.enforceInterface(DESCRIPTOR);
                    serviceImpl.unsubscribe();
                    return true;
                }
                case TRANSACTION_close_2: {
                    data.enforceInterface(DESCRIPTOR);
                    serviceImpl.close();
                    return true;
                }


            }
        } catch (Exception re) {
        }
        return super.onTransact(code, data, reply, flags);
    }
}
