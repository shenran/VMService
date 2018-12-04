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

import com.alibaba.fastjson.JSONObject;
public class CallAsynFunction {

    JSONObject Msg2Send=null;
    FunctionReturn Msg2Recv=null;



    public  JSONObject getReturn()
    {
        //Log.d("getReturn", "getReturn: "+Msg2Recv.rev.toJSONString());
        if(Msg2Recv.status==200)
            return Msg2Recv.rev;
        else
            return null;
    }
    public CallAsynFunction(String strMsg)
    {
        Msg2Send=JSONObject.parseObject(strMsg);
        Msg2Recv=new FunctionReturn();
        Msg2Recv.id=3;
        Msg2Recv.status=400;
        MessageProcessor.getInstance().AddWriteMessage(Msg2Send,Msg2Recv);
        synchronized (Msg2Recv) {
            try {
                Msg2Recv.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
