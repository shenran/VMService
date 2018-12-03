package cn.ishenran.vm.serialport;

import android.serialport.api.SerialPort;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.ishenran.vm.lib.Decoder;
import cn.ishenran.vm.message.MessageProcessor;


public class SerialPortReadRunnable implements Runnable  {
    //SerialPort m_serialPort=null;
    private InputStream SerialPortInputStream=null;
    private Decoder m_decoder=null;
    private  final int RATE=200;
    public SerialPortReadRunnable(SerialPort serialPort,Decoder decoder)
    {
        m_decoder=decoder;
        //m_serialPort=serialPort;
        SerialPortInputStream=serialPort.getInputStream();
    }
    boolean isRunning;
    public void StopThread()
    {
        isRunning=false;
    }
    @Override
    public void run() {
        Log.d("SerialPortReadRunnable", "run: ");
        isRunning=true;
        int nMaxBufLength = 1024;
        byte[] buffer = new byte[nMaxBufLength];
        ByteArrayOutputStream message=new ByteArrayOutputStream();
        while (isRunning)
        {
            try{
                int byteRead = -1;
                Thread.sleep(RATE);
                if(SerialPortInputStream.available()>0){
                    byteRead = SerialPortInputStream.read(buffer);
                    if(byteRead > 0){
                        if(m_decoder.getDataByte(buffer,byteRead,message))
                        {
                            byte[] bMessage=message.toByteArray();
                            MessageProcessor.getInstance().AddReadMessageQueue(bMessage);
                            message.reset();
                        }
                    }
                }

            }catch (IOException e)
            {
                isRunning=false;
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            }

        }
    }
}
