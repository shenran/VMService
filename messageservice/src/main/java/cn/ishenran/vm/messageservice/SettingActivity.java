package cn.ishenran.vm.messageservice;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.ishenran.vm.messageservice.service.MessageService;


public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent i = new Intent(this, MessageService.class);
        this.startService(i);
        MessageReceiver recevier = new MessageReceiver();
        IntentFilter intentFilter = new IntentFilter("cn.ishenran.vm.messageservice");
        registerReceiver(recevier, intentFilter);
    }
}
