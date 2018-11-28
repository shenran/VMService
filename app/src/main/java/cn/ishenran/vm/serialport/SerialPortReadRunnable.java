package cn.ishenran.vm.serialport;

import android.serialport.api.SerialPort;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.ishenran.vm.message.Decoder;

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
    boolean isRunning=true;
    @Override
    public void run() {
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
                            message.flush();
                            byte[] bMessage=message.toByteArray();
                            m_decoder.AddMessageQueue(bMessage);
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
