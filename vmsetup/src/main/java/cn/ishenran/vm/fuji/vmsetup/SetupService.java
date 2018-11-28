package cn.ishenran.vm.fuji.vmsetup;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cn.ishenran.vm.vmservice.ISendCallBack;
import cn.ishenran.vm.vmservice.VmcMain;
import cn.ishenran.vm.vmservice.msg.BaseMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithCashPriceMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithSpidMsg;
import cn.ishenran.vm.vmservice.observer.VmcBaseObserver;

public class SetupService extends Service {

    /**
     * 串口Observer
     * 用来接收单片机发送的消息
     */
    private class VmcObserver implements VmcBaseObserver {
        @Override
        public void notify(BaseMsg baseMsg) {

            switch (baseMsg.getClass().getName())
            {
                case "InfoRptWithSpidMsg":
                {

                }
                break;
                case "":
                {

                }
                break;
                default:
                    break;

            }
        }
    }
    private VmcObserver mVmcObserver;
    @Override
    public void onCreate() {
        super.onCreate();
        VmcMain.init(this);

    }

    public SetupService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
