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
package cn.ishenran.vm.serialport.config;

public class SerialPortConfig {
    static public final String SERIAL_PORT_PATH="/dev/ttyS0";
    static public final int BAUD_RATE=9600;
    static public String DRIVER_JAR="/mnt/sdcard/SPData/Jar/test.aar";
    static public final String BROADCAST_ACTION="cn.ishenran.vm.messageservice";
    static public final String BASE_PATH="/sdcard/SPData";
    static public final String ENCODER_NAME="vm.protocol.test.Encoder";
    static public final String DECODER_NAME="vm.protocol.test.Decoder";

}
