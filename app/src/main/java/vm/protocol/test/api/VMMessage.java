package vm.protocol.test.api;

import android.os.RemoteException;

import com.alibaba.fastjson.JSONObject;

import cn.ishenran.vm.api.ICallAsynFunction;

public class VMMessage {

    private  ICallAsynFunction m_callAsynFunction=null;
    public VMMessage(ICallAsynFunction callAsynFunction)
    {
        m_callAsynFunction=callAsynFunction;
    }
    public boolean OpenDoor(int RoomNo)
    {
        JSONObject obj=new JSONObject();
        obj.put("RoomNo",RoomNo);
        obj.put("Action",1);

        String rev=null;
        try {
            rev=m_callAsynFunction.CallAsynFunction(0,obj.toJSONString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(rev!=null) {
            JSONObject jrev = JSONObject.parseObject(rev);
            return jrev.getBoolean("SUC");
        }
        return false;
    }
}
