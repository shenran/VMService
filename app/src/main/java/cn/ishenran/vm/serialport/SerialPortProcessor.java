package cn.ishenran.vm.serialport;

import android.serialport.api.SerialPort;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import cn.ishenran.vm.message.Decoder;
import cn.ishenran.vm.message.Encoder;
import vm.protocol.fuji.message.VmcBaseMsg;


public class SerialPortProcessor {

    private static SerialPortProcessor instance=null;
    public static SerialPortProcessor getInstance()
    {
        if(instance==null)
            instance=new SerialPortProcessor();
        return instance;
    }

    public void sendMessage(JSONObject msg)
    {
        encoder.encode(msg);
    }
    public void recevierMessage(JSONObject msg)
    {
        encoder.encode(msg);
    }

    Encoder encoder=null;
    Decoder decoder=null;
    public void init(String encoderName, String decoderName)
    {
        //CountDownLatch
        try {
            SerialPort sp=SerialPortUtil.getSerialPort();
            encoder= (Encoder) Encoder.class.forName(encoderName).newInstance();
            decoder=(Decoder)Decoder.class.forName(decoderName) .newInstance();
            Thread readThread=new Thread(new SerialPortReadRunnable(sp,decoder));
            Thread writeThread=new Thread(new SerialPortWriteRunnable(sp,encoder));

            readThread.start();
            writeThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void CloseSerialPort()
    {
        SerialPortUtil.closeSerialPort();
    }
}
