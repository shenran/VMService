package cn.ishenran.vm.serialport;

import android.serialport.api.SerialPort;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;

import cn.ishenran.vm.lib.Encoder;
import cn.ishenran.vm.message.MessageProcessor;


public class SerialPortWriteRunnable  implements Runnable {
    boolean isRunning;
    private OutputStream SerialPortOutputStream=null;
    //private Encoder m_encoder;

    public SerialPortWriteRunnable(SerialPort serialPort, Encoder encoder)
    {
        //m_encoder=encoder;
        //m_serialPort=serialPort;

        SerialPortOutputStream=serialPort.getOutputStream();
    }
    public void StopThread()
    {
        isRunning=false;

    }
    @Override
    public void run() {
        Log.d("SerialPortWriteRunnable", "run: ");
        isRunning=true;
        while (isRunning) {
            try {
                int byteRead = -1;
                //Thread.sleep(RATE);
                byte[] buffer = MessageProcessor.getInstance().getWriteBuffer();
                if(buffer!=null)
                    SerialPortOutputStream.write(buffer);

            } catch (IOException e) {
                isRunning = false;
                break;
            }

        }
    }
}
