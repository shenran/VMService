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
import android.serialport.api.SerialPortFinder;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import cn.ishenran.vm.serialport.config.SerialPortConfig;


/**
 * Created by Portgas.D.Ace on 2016/7/25.
 */
public class SerialPortUtil {
    private static final String SERIAL_NAME = "android_serialPort";

    public SerialPortFinder mSerialPortFinder = new SerialPortFinder();
    private static SerialPort mSerialPort = null;


    /**
     * 获取串口端口的方法
     *
     * @return
     * @throws SecurityException
     * @throws IOException
     * @throws InvalidParameterException
     */
    public static SerialPort getSerialPort() throws SecurityException, IOException, InvalidParameterException {
        if (mSerialPort == null) {
            /* Read serial port parameters */

            String path = SerialPortConfig.SERIAL_PORT_PATH;
            int baudrate = SerialPortConfig.BAUD_RATE;

			/* Check parameters */
            if ((path.length() == 0) || (baudrate == -1)) {
                throw new InvalidParameterException();
            }

			/* Open the serial port */
            mSerialPort = new SerialPort(new File(path), baudrate, 0, 8, 1, 0);
        }
        return mSerialPort;
    }

    /**
     * 关闭串口端口号
     */
    public static void closeSerialPort() {
        if (mSerialPort != null) {
            mSerialPort.close();
            mSerialPort = null;
        }
    }



    /**
     * 计算校验位的方法
     * 规则：除Fcc位字节之外的和
     *
     * @param buffer
     * @return
     */
    public static byte getFcc(byte[] buffer) {
        byte fcc = 0;
        for (int i = 0; i < buffer.length - 1; i++) {
            fcc += buffer[i];
        }
        return fcc;
    }

}
