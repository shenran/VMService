package cn.ishenran.vm.vmcservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;

import cn.ishenran.vm.serialport.SerialPortProcessor;
import cn.ishenran.vm.serialport.SerialPortUtil;
import cn.ishenran.vm.serialport.config.SerialPortConfig;
import vm.protocol.fuji.api.*;
import vm.protocol.fuji.stub.IConfigIndMsgStub;
import vm.protocol.fuji.stub.IControlIndMsgStub;
import vm.protocol.fuji.stub.ICostIndMsgStub;
import vm.protocol.fuji.stub.IGetInfoMsgStub;
import vm.protocol.fuji.stub.IGetStatusMsgStub;
import vm.protocol.fuji.stub.IVendoutIndMsgStub;

public class VmcService extends Service {
    public VmcService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VMMessageReceiver recevier = new VMMessageReceiver();
        IntentFilter intentFilter = new IntentFilter(SerialPortConfig.BROADCAST_ACTION);
        registerReceiver(recevier, intentFilter);
        SerialPortProcessor.getInstance().init("vm.protocol.fuji.Encoder","vm.protocol.fuji.Decoder");
    }

    @Override
    public void onDestroy() {
        SerialPortUtil.closeSerialPort();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }

    IMessage.Stub mBinder=new IMessage.Stub() {
        @Override
        public IConfigIndMsg VMConfig() throws RemoteException {
            return IConfigIndMsgStub.Stub;
        }

        @Override
        public IControlIndMsg VMControl() throws RemoteException {
            return IControlIndMsgStub.Stub;
        }

        @Override
        public ICostIndMsg VMCost() throws RemoteException {
            return ICostIndMsgStub.Stub;
        }

        @Override
        public IGetInfoMsg VMGetInfo() throws RemoteException {
            return IGetInfoMsgStub.Stub;
        }

        @Override
        public IGetStatusMsg VMGetStatus() throws RemoteException {
            return IGetStatusMsgStub.Stub;
        }

        @Override
        public IVendoutIndMsg VMVendout() throws RemoteException {
            return new IVendoutIndMsgStub();
        }
    };
}
