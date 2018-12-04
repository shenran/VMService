/*
 * Copyright [2018] [by shenran]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @Author:shenran@ishenran.cn
 * @LastModified:2018-12-04T10:49:49.421+08:00
 *
 *
 */

package cn.ishenran.vm.serialport;

import android.serialport.api.SerialPort;
import android.util.Log;
import java.io.IOException;
import cn.ishenran.vm.lib.Decoder;
import cn.ishenran.vm.lib.Encoder;

/**
 * 串口处理器
 *
 */
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
