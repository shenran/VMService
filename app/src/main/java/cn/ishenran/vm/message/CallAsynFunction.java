package cn.ishenran.vm.message;

import com.alibaba.fastjson.JSONObject;

import cn.ishenran.vm.serialport.SerialPortProcessor;

public class CallAsynFunction {

    JSONObject Msg2Send=null;
    JSONObject Msg2Recv=null;
    Object WaitObj=new Object();
    public void setReturn(JSONObject Recv)
    {
        Msg2Recv=Recv;
    }

    public  JSONObject getReturn()
    {
        return Msg2Recv;
    }
    public CallAsynFunction(String strMsg)
    {
        Msg2Send=JSONObject.parseObject(strMsg);
        SerialPortProcessor.getInstance().sendMessage(Msg2Send);
        synchronized (WaitObj) {
            try {
                WaitObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
