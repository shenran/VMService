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

package cn.ishenran.vm.message;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import cn.ishenran.vm.lib.Decoder;
import cn.ishenran.vm.lib.Encoder;

public class MessageProcessor {

    static MessageProcessor instance = null;

    public static MessageProcessor getInstance() {
        if (instance == null)
            instance = new MessageProcessor();
        return instance;
    }

    private Encoder m_encoder = null;
    private Decoder m_decoder = null;

    public void init(Encoder encoder, Decoder decoder) {
        m_encoder = encoder;
        m_decoder = decoder;
        WriteMessageQueue = m_encoder.getWriteMessageQueue();
        if (WriteMessageQueue == null)
            WriteMessageQueue = new ArrayList<byte[]>();
        StartThread();
    }


    public ArrayList<byte[]> ReadMessageQueue = new ArrayList<byte[]>();
    public ArrayList<byte[]> WriteMessageQueue = null;
    private boolean isRunning = false;


    public void AddReadMessageQueue(byte[] bytes) {
        ReadMessageQueue.add(bytes);
        //if(MessageQueue.)
        synchronized (ReadMessageQueue) {
            ReadMessageQueue.notifyAll();
        }

    }

    public void StopThread() {
        isRunning = false;
        synchronized (ReadMessageQueue) {
            ReadMessageQueue.notifyAll();
        }
    }

    public void StartThread() {


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                Log.d("MessageProcessor", "run: ");
                while (isRunning) {

                    if (!ReadMessageQueue.isEmpty()) {
                        JSONObject rev = m_decoder.decode(ReadMessageQueue.get(0));
                        Integer id = m_decoder.getCallFunById(rev);
                        RevReturnMessage(id, rev);
                        ReadMessageQueue.remove(0);
                    } else {
                        try {
                            synchronized (ReadMessageQueue) {
                                ReadMessageQueue.wait();
                            }
                        } catch (InterruptedException e) {
                            Log.e(this.getClass().getName(), "run: ", e);
                        }
                    }
                }
            }
        });
        t.start();

    }

    public void AddWriteMessage(JSONObject msg, FunctionReturn obj) {

        Integer FunId = m_encoder.encode(msg);
        CallFunctionQueue.put(FunId, obj);
    }

    public void RevReturnMessage(Integer id, JSONObject msg) {
        FunctionReturn obj = CallFunctionQueue.get(id);
        if (obj != null) {
            obj.rev = msg;
            obj.status = 200;
            Log.d("RevReturnMessage", "RevReturnMessage: " + obj.id);
            synchronized (obj) {
                obj.notifyAll();
            }
            CallFunctionQueue.remove(id);
        }
    }

    public byte[] getWriteBuffer() {
        if (WriteMessageQueue.isEmpty()) {
            try {
                synchronized (WriteMessageQueue) {
                    WriteMessageQueue.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        m_encoder.WaitWrite();
        byte[] buffer = WriteMessageQueue.get(0);
        WriteMessageQueue.remove(0);
        return buffer;
    }

    HashMap<Integer, FunctionReturn> CallFunctionQueue = new HashMap<Integer, FunctionReturn>();

}
