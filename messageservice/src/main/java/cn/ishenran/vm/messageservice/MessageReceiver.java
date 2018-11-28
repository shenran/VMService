package cn.ishenran.vm.messageservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

            // TODO: This method is called when the BroadcastReceiver is receiving
            // an Intent broadcast.
            String Method=intent.getStringExtra("method");
            String MsgId=intent.getStringExtra("msgId");
            //Toast.makeText(m_act, Method+":"+MsgId,  Toast.LENGTH_LONG).show();

    }
}
