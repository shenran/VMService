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
 * @LastModified:2018-12-04T16:18:38.334+08:00
 *
 *
 */

package vm.protocol.test.api;

import android.os.RemoteException;

import com.alibaba.fastjson.JSONObject;

import cn.ishenran.vm.api.ICallAsynFunction;

/**
 * 设备驱动方法API
 * 目前只提供一个开门方法作为用例
 */
public class VMMessage {

    private  ICallAsynFunction m_callAsynFunction=null;
    public VMMessage(ICallAsynFunction callAsynFunction)
    {
        m_callAsynFunction=callAsynFunction;
    }
    public boolean OpenDoor(int RoomNo)
    {
        JSONObject obj=new JSONObject();
        obj.put("RoomNo",RoomNo);
        obj.put("Action",1);

        String rev=null;
        try {
            rev=m_callAsynFunction.CallAsynFunction(0,obj.toJSONString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(rev!=null) {
            JSONObject jrev = JSONObject.parseObject(rev);
            return jrev.getBoolean("SUC");
        }
        return false;
    }
}
