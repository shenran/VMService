package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc启动状态报告
 * Created by ning on 2017/3/31.
 */

public class ActionRptWithStartStatusMsg implements BaseMsg{
    /**启动中*/
    public static final int STANDBY_STARTING = 0;
    /**启动完成*/
    public static final int STANDBY_STARTED = 1;

    private int standby;

    public ActionRptWithStartStatusMsg() {
    }

    public ActionRptWithStartStatusMsg(int standby) {
        this.standby = standby;
    }

    public int getStandby() {
        return standby;
    }

    public void setStandby(int standby) {
        this.standby = standby;
    }
}
