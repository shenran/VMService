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
 * @LastModified:2018-12-04T16:20:26.044+08:00
 *
 *
 */
package cn.ishenran.vm.lib;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public interface Encoder {
    //写入同步器，确定写入的时机
    void WaitWrite();
    //获取写入消息队列，等待串口写线程取出并写入串口
    ArrayList<byte[]> getWriteMessageQueue();
    //抽象编码器，用于将JSON对象转成串口字节串
    Integer encode(JSONObject message);
}
