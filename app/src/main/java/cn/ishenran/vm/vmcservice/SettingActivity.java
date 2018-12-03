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
