package cn.ishenran.vm.message;

import android.os.Handler;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public abstract class Decoder {
    protected abstract void decode(byte[] bytes);
    public abstract boolean getDataByte(byte[] bytes,int len,ByteArrayOutputStream message);

    public ArrayList<byte[]> MessageQueue=new ArrayList<byte[]>();
    protected Handler m_handle=null;
    private boolean isRunning=false;


    public void AddMessageQueue(byte[] bytes)
    {
        MessageQueue.add(bytes);
        //if(MessageQueue.)
        synchronized (MessageQueue) {
            MessageQueue.notifyAll();
        }

    }

    public void StopThread()
    {
        isRunning=false;
        synchronized (MessageQueue) {
            MessageQueue.notifyAll();
        }

    }
    public Decoder()
    {
        Init("decoder", null);
    }
    public void Init(String name, Handler handler)
    {

        m_handle=handler;
        isRunning=true;
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    if (!MessageQueue.isEmpty()) {
                        decode(MessageQueue.get(0));
                        MessageQueue.remove(0);
                    }
                    else
                    {
                        try {
                            synchronized (MessageQueue) {
                                MessageQueue.wait();
                            }
                        } catch (InterruptedException e) {
                            Log.e(this.getClass().getName(), "run: ",e );
                        }
                    }
                }
            }
        });
        t.setName(name);
        t.start();

    }
}
