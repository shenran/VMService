package cn.ishenran.vm.fuji.vmsetup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

import java.util.HashMap;

import cn.ishenran.vm.vmservice.ISendCallBack;
import cn.ishenran.vm.vmservice.VmcMain;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithCashPriceMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithSpidMsg;

public class FUJISetupReceiver extends BroadcastReceiver {
    private static final int HANDLER_START_VIDEO = 0;
    public static final int HANDLER_SHOW_VIDEO_FRAME = 1;
    public static final int HANDLER_START_PAY_ACTIVITY = 2;
    public static final int HANDLER_BACK_TIME = 3;
    public static final int HANDLER_PAGER_ADAPER_NOTIFY_CHANGE = 4;
    public static final int HANDLER_CONFIG_SPID = 5;
    public static final int HANDLER_CONFIG_CASH = 6;

    public static final int EACH_PAGER_NUM = 4;//每页展示的商品个数

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(!VmcMain.isServiceConnect())
        {
            return;
        }
        String Method=intent.getStringExtra("Method");
        switch (Method) {

            case "CONFIG_SPID":
                //设置商品spid
                //TODO 接口商品id是int值，写入单片机，如果不是int类型的id可能会有问题
                final HashMap spidMap = getSpidMap();
                ConfigIndWithSpidMsg configIndWithSpidMsg = new ConfigIndWithSpidMsg(spidMap.size(), spidMap);
                VmcMain.sendMsgWithCallBack(configIndWithSpidMsg, new ISendCallBack.Stub() {
                    @Override
                    public void onSuccess() throws RemoteException {
                        //FileLogUtil.writeHttpLog("设置spid成功:" + DataUtil.traverseMap(spidMap));
                    }

                    @Override
                    public void onError() throws RemoteException {
                        //sendEmptyMessageDelayed(HANDLER_CONFIG_SPID, 1000 * 60);
                        //FileLogUtil.writeHttpLog("设置spid失败::" + DataUtil.traverseMap(spidMap));
                    }
                });
                break;
            case "CONFIG_CASH":
                //设置货道现金单价
                final HashMap priceMap = getPriceMap();
                ConfigIndWithCashPriceMsg configIndWithCashPriceMsg = new ConfigIndWithCashPriceMsg(priceMap.size(), priceMap);
                VmcMain.sendMsgWithCallBack(configIndWithCashPriceMsg, new ISendCallBack.Stub() {
                    @Override
                    public void onSuccess() throws RemoteException {
                        //FileLogUtil.writeHttpLog("设置cash成功:" + DataUtil.traverseMap(priceMap));
                    }

                    @Override
                    public void onError() throws RemoteException {
                        //sendEmptyMessageDelayed(HANDLER_CONFIG_CASH, 60 * 1000);
                        //FileLogUtil.writeHttpLog("设置cash失败::" + DataUtil.traverseMap(priceMap));
                    }
                });
                break;
        }
    }

    private HashMap getSpidMap() {
        //组装spids
        HashMap<Integer, Integer> spidMap = new HashMap<Integer, Integer>();


        return spidMap;
    }

    private HashMap getPriceMap() {
        HashMap<Integer, Integer> priceMap = new HashMap<Integer, Integer>();

        return priceMap;
    }
}
