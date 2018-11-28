package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 进入/退出维护模式
 * Created by ning on 2017/3/31.
 */

public class ServiceRptWihtEngModeMsg implements BaseMsg {
    /**退出维护模式*/
    public static final int EXIT_MODE = 0;
    /**进入维护模式*/
    public static final int ENTER_MODE = 1;
    private int serviceMode;

    public ServiceRptWihtEngModeMsg() {
    }

    public ServiceRptWihtEngModeMsg(int serviceMode) {
        this.serviceMode = serviceMode;
    }

    public int getServiceMode() {
        return serviceMode;
    }

    public void setServiceMode(int serviceMode) {
        this.serviceMode = serviceMode;
    }
}
