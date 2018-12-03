package vm.protocol.test;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;


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



    public void WaitWrite() {

    }


    @Override
    public ArrayList<byte[]> getWriteMessageQueue() {
        if(WriteMessageQueue==null)
            WriteMessageQueue=new ArrayList<byte[]>();
        return WriteMessageQueue;
    }


}
