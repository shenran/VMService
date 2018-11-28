package cn.ishenran.vm.serialport;

import android.serialport.api.SerialPort;

import java.io.IOException;
import java.io.OutputStream;

import cn.ishenran.vm.message.Encoder;

public class SerialPortWriteRunnable  implements Runnable {
    boolean isRunning=true;
    private OutputStream SerialPortOutputStream=null;
    private Encoder m_encoder;

    public SerialPortWriteRunnable(SerialPort serialPort, Encoder encoder)
    {
        m_encoder=encoder;
        //m_serialPort=serialPort;
        SerialPortOutputStream=serialPort.getOutputStream();
    }
    @Override
    public void run() {
        while (isRunning) {
            try {
                int byteRead = -1;
                //Thread.sleep(RATE);
                byte[] buffer = m_encoder.getWriteBuffer();
                if(buffer!=null)
                    SerialPortOutputStream.write(buffer);

            } catch (IOException e) {
                isRunning = false;
                break;
            }

        }
    }
}
