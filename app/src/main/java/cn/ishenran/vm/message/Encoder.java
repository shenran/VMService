package cn.ishenran.vm.message;


import java.util.ArrayList;

public abstract class Encoder {
    public Encoder() {
    }

    ///
    ///实现该方法后续调用AddMessageQueue
    public abstract void encode(Object message);
    ///
    ///等待写入信号，当直接写入的时候该方法为空
    protected abstract void WaitWrite();
    protected abstract void HoldWrite();
    public ArrayList<byte[]> MessageQueue=new ArrayList<byte[]>();

    public void AddMessageQueue(byte[] bytes) {
        MessageQueue.add(bytes);
    }


    public byte[] getWriteBuffer()
    {
        if(MessageQueue.isEmpty())
        {
            try {
                synchronized (MessageQueue) {
                    MessageQueue.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        WaitWrite();
        byte[] buffer= MessageQueue.get(0);
        MessageQueue.remove(0);
        HoldWrite();
        return buffer;
    }


}
