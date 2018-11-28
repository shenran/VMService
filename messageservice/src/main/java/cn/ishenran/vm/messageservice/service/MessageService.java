package cn.ishenran.vm.messageservice.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import cn.ishenran.vm.messageservice.MessageReceiver;

public class MessageService extends Service implements MessageDelegate{
    public MessageService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String SerialNumber = android.os.Build.SERIAL;
        Log.d("SerialNumber",SerialNumber);
        MessageClient client=new MessageClient(SerialNumber,this);
        MessageReceiver recevier = new MessageReceiver();
        IntentFilter intentFilter = new IntentFilter("cn.ishenran.vm.messageservice");
        registerReceiver(recevier, intentFilter);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void messageArrived(String Message) {

        JSONObject message =JSONObject.parseObject(Message);
        String Action=message.getString("action");
        Intent intent = new Intent();
        intent.setAction(Action);
        String Method=message.getString("method");
        String MsgId=message.getString("msgId");
        String Body=message.getString("body");
        intent.putExtra("method", Method);
        intent.putExtra("msgId", MsgId);
        intent.putExtra("body", Body);
        sendBroadcast(intent);
    }
}
