package cn.ishenran.vm.messageservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.ishenran.vm.messageservice.service.MessageService;

public class BootCompletedBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent i = new Intent(context, MessageService.class);
        context.startService(i);
    }
}
