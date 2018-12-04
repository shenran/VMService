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
