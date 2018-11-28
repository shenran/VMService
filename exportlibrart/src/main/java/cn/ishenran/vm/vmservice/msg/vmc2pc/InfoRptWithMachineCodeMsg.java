package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 机器编号
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithMachineCodeMsg implements BaseMsg {
    private String machineId;

    public InfoRptWithMachineCodeMsg() {
    }

    public InfoRptWithMachineCodeMsg(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }
}
