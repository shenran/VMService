package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc门开关事件
 * Created by ning on 2017/3/30.
 */

public class ServiceRptWithDoorSwMsg implements BaseMsg {
    /**关门*/
    public static final int DOOW_CLOSE = 0;
    /**开门*/
    public static final int DOOW_OPEN = 0;

    private int doorSw;

    public ServiceRptWithDoorSwMsg() {
    }

    public ServiceRptWithDoorSwMsg(int doorSw) {
        this.doorSw = doorSw;
    }

    public int getDoorSw() {
        return doorSw;
    }

    public void setDoorSw(int doorSw) {
        this.doorSw = doorSw;
    }
}
