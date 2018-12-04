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
 * @LastModified:2018-12-04T16:20:25.987+08:00
 *
 *
 */
package cn.ishenran.vm.lib;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;

public interface Decoder {

    //抽象的解码器，用于编写串口解码方法，结果通过JSON格式返回
    JSONObject decode(byte[] bytes);
    //同步函数调用方法，根据返回值，获取串口读写的对位序列号
    Integer getCallFunById(JSONObject rev);
    //获取串口数据方法，用于完成串口消息的拼接和验证
    boolean getDataByte(byte[] bytes, int len, ByteArrayOutputStream message);


}
