package cn.ishenran.vm.serialport;


import android.serialport.api.SerialPort;
import android.serialport.api.SerialPortFinder;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;



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

            String path = "/dev/ttyS0";
            int baudrate = 9600;

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
     * 获取机器可用的串口端口号并保存到SharedPreference中
     */
    public static void initSerialPort() {
        SerialPortFinder serialPortFinder = new SerialPortFinder();
        String[] entries = serialPortFinder.getAllDevices();
        String[] entryValues = serialPortFinder.getAllDevicesPath();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                Log.d("entries", entries[i]);
            }
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
