package vm.protocol.test;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * 本类需要继承cn.ishenran.vm.lib.Encoder接口
 * 实现相应的方法，以便由驱动管理器调用
 */
public class Encoder implements cn.ishenran.vm.lib.Encoder{
    public Encoder() {
    }
    ArrayList<byte[]> WriteMessageQueue=new ArrayList<byte[]>();

    byte sn=1;
    @Override
    public Integer encode(JSONObject message) {

        byte action =message.getByte("Action");
        byte roomNo =message.getByte("RoomNo");
        byte[] bMessage={0x12,sn,action,roomNo,0x22};
        sn++;
        WriteMessageQueue.add(bMessage);
        synchronized(WriteMessageQueue) {
            WriteMessageQueue.notifyAll();
        }
        return Integer.valueOf (0xff & bMessage[1] );
    }


    @Override
    public void WaitWrite() {

    }


    @Override
    public ArrayList<byte[]> getWriteMessageQueue() {
        if(WriteMessageQueue==null)
            WriteMessageQueue=new ArrayList<byte[]>();
        return WriteMessageQueue;
    }


}
