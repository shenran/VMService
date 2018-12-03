package cn.ishenran.vm.serialport;

import android.content.Context;
import android.os.Environment;
import android.serialport.api.SerialPort;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;


import cn.ishenran.vm.lib.Decoder;
import cn.ishenran.vm.lib.Encoder;
import cn.ishenran.vm.message.MessageProcessor;
import dalvik.system.DexClassLoader;


public class SerialPortProcessor {

    private static SerialPortProcessor instance=null;
    public static SerialPortProcessor getInstance()
    {
        if(instance==null)
            instance=new SerialPortProcessor();
        return instance;
    }



    SerialPortReadRunnable serialPortReadRunnable=null;
    SerialPortWriteRunnable serialPortWriteRunnable =null;
    public void init(Encoder encoder, Decoder decoder)
    {
        /*
        final File optimizedDexOutputPath = new File(Environment.getExternalStorageDirectory().toString()
                + File.separator + "test.jar");
        // Initialize the class loader with the secondary dex file.
        DexClassLoader cl = new DexClassLoader(optimizedDexOutputPath.getAbsolutePath(),
                Environment.getExternalStorageDirectory().toString(), null, context.getClassLoader());
        Class libDecoderClazz = null;
        Class libEncoderClazz = null;
        //CountDownLatch
        */

        try {
            /*
            libDecoderClazz = cl.loadClass("cn.ishenran.vm.lib.Decoder");
            libEncoderClazz = cl.loadClass("cn.ishenran.vm.lib.Encoder");
            //IDynamic lib = (IDynamic)libProviderClazz.newInstance();

            */
            SerialPort sp=SerialPortUtil.getSerialPort();

            serialPortReadRunnable=new SerialPortReadRunnable(sp,decoder);
            serialPortWriteRunnable=new SerialPortWriteRunnable(sp,encoder);
            Thread readThread=new Thread(serialPortReadRunnable);
            Thread writeThread=new Thread(serialPortWriteRunnable);
            readThread.start();
            writeThread.start();
            //
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("sp", "init: writeThread"+e.getMessage());

        }
    }

    public void CloseSerialPort()
    {
        serialPortWriteRunnable.StopThread();
        serialPortReadRunnable.StopThread();

        SerialPortUtil.closeSerialPort();
    }
}
