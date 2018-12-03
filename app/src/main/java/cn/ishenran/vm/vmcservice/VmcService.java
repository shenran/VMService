package cn.ishenran.vm.vmcservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;

import com.alibaba.fastjson.JSONObject;

import cn.ishenran.vm.api.ICallAsynFunction;
import cn.ishenran.vm.lib.Decoder;
import cn.ishenran.vm.lib.Encoder;
import cn.ishenran.vm.message.CallAsynFunction;
import cn.ishenran.vm.message.MessageProcessor;
import cn.ishenran.vm.serialport.SerialPortProcessor;
import cn.ishenran.vm.serialport.SerialPortUtil;
import cn.ishenran.vm.serialport.config.SerialPortConfig;

public class VmcService extends Service {
    public VmcService() {
    }

    Encoder encoder=null;
    Decoder decoder=null;
    @Override
    public void onCreate() {
        super.onCreate();
        VMMessageReceiver recevier = new VMMessageReceiver();
        IntentFilter intentFilter = new IntentFilter(SerialPortConfig.BROADCAST_ACTION);
        registerReceiver(recevier, intentFilter);
        try {
            encoder= vm.protocol.test.Encoder.class.newInstance();
            decoder= vm.protocol.test.Decoder.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        MessageProcessor.getInstance().init(encoder,decoder);
        SerialPortProcessor.getInstance().init(encoder,decoder);


    }

    @Override
    public void onDestroy() {
        SerialPortProcessor.getInstance().CloseSerialPort();
        MessageProcessor.getInstance().StopThread();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }

    ICallAsynFunction.Stub mBinder= new ICallAsynFunction.Stub() {
        @Override
        public String CallAsynFunction(int FunctionID, String data) throws RemoteException {

            CallAsynFunction fun=new CallAsynFunction(data);

            JSONObject rev=fun.getReturn();
            if(rev!=null)
                return rev.toJSONString();
            else
                return null;
        }


    };
}
