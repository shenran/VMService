package cn.ishenran.vm.vmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import cn.ishenran.vm.vmservice.msg.BaseMsg;
import cn.ishenran.vm.vmservice.msg.VmcMsg;
import cn.ishenran.vm.vmservice.observer.VmcBaseObserver;
import cn.ishenran.vm.vmservice.util.MsgUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Pc与Vmc通讯服务
 * Created by ning on 2017/3/8.
 */

public class VmcMain {
    private static IVmcMsgService mVmcService = null;
    private static Context mContext = null;
    private static final IReceiveCallBack cb = new IReceiveCallBack.Stub() {
        @Override
        public void receiveMsg(int msgType, String msgBody) throws RemoteException {
            BaseMsg baseMsg = MsgUtil.decodeVmcMsg(msgType, msgBody);
            if (baseMsg != null) {
                notifyObserver(baseMsg);
            }
        }
    };
    private static ServiceConnection mServiceConnection = null;
    private static final List<VmcBaseObserver> mVmcBaseObservers = new ArrayList<>();

    public static void init(Context context) {
        mContext = context;
        mServiceConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {
                mVmcService = IVmcMsgService.Stub.asInterface(paramAnonymousIBinder);
                try {
                    mVmcService.registerCallback(cb);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
                mVmcService = null;
            }
        };
        Intent intent = new Intent("cn.ishenran.vm.vmservice.vmcservice");
        intent.setPackage("cn.ishenran.vm.vmservice.vmcservice");
        context.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public static boolean isServiceConnect() {
        return mVmcService != null;
    }

    public static void sendMsg(BaseMsg msg) {
        if (!isServiceConnect()) {
            //未连接 重连
            if (mContext != null) {
                init(mContext);
            }
            return;
        }
        VmcMsg vmcMsg = MsgUtil.encodeVmcMsg(msg);
        if (vmcMsg != null) {
            try {
                mVmcService.sendMsg(vmcMsg.getMsgType(), vmcMsg.getMsgBody());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendMsgWithCallBack(BaseMsg msg, ISendCallBack cb) {
        if (!isServiceConnect()) {
            //未连接 重连
            if (mContext != null) {
                init(mContext);
            }
            return;
        }
        VmcMsg vmcMsg = MsgUtil.encodeVmcMsg(msg);
        if (vmcMsg != null) {
            try {
                mVmcService.sendMsgWithCallBack(vmcMsg.getMsgType(), vmcMsg.getMsgBody(), cb);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }

    public static void addObserver(VmcBaseObserver observer) {
        if (observer != null) {
            mVmcBaseObservers.add(observer);
        }
    }

    public static void deleteObserver(VmcBaseObserver observer) {
        if (observer != null) {
            mVmcBaseObservers.remove(observer);
        }
    }

    private static void notifyObserver(BaseMsg msg) {
        for (VmcBaseObserver observer : mVmcBaseObservers) {
            observer.notify(msg);
        }
    }
}
