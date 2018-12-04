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
