package cn.ishenran.vm.message;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import cn.ishenran.vm.serialport.SerialPortProcessor;

public class CallAsynFunction {

    JSONObject Msg2Send=null;
    FunctionReturn Msg2Recv=null;



    public  JSONObject getReturn()
    {
        //Log.d("getReturn", "getReturn: "+Msg2Recv.rev.toJSONString());
        if(Msg2Recv.status==200)
            return Msg2Recv.rev;
        else
            return null;
    }
    public CallAsynFunction(String strMsg)
    {
        Msg2Send=JSONObject.parseObject(strMsg);
        Msg2Recv=new FunctionReturn();
        Msg2Recv.id=3;
        Msg2Recv.status=400;
        MessageProcessor.getInstance().AddWriteMessage(Msg2Send,Msg2Recv);
        synchronized (Msg2Recv) {
            try {
                Msg2Recv.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
