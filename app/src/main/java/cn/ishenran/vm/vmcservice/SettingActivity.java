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

package cn.ishenran.vm.vmcservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.ishenran.vm.api.ICallAsynFunction;
import vm.protocol.test.api.VMMessage;

public class SettingActivity extends AppCompatActivity {

    VMMessage vmMessage=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent i = new Intent(this, VmcService.class);

        this.bindService(i, this.mServiceConnection, Context.BIND_AUTO_CREATE);

        Button btnTest=(Button)findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    boolean o=vmMessage.OpenDoor(10);
                    Log.d("OK", "onClick: "+o);

            }
        });
    }
    private ICallAsynFunction callAsynFunction;
    ServiceConnection mServiceConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            callAsynFunction=ICallAsynFunction.Stub.asInterface(service);
            //Log.d("iMessage", "iMessage: "+iMessage.getClass().getName());
            vmMessage=new VMMessage(callAsynFunction);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
