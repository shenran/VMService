package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc能力
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithVmcPowerMsg implements BaseMsg {
    //支持的离线数据条数
    private int offLineDataMaxNum;

    public InfoRptWithVmcPowerMsg() {
    }

    public InfoRptWithVmcPowerMsg(int offLineDataMaxNum) {
        this.offLineDataMaxNum = offLineDataMaxNum;
    }

    public int getOffLineDataMaxNum() {
        return offLineDataMaxNum;
    }

    public void setOffLineDataMaxNum(int offLineDataMaxNum) {
        this.offLineDataMaxNum = offLineDataMaxNum;
    }
}
