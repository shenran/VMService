package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 设置机器编号
 * Created by ning on 2017/3/23.
 */

public class ConfigIndWithMachineCodeMsg implements BaseMsg {
    //机器编号
    private String machineCode;

    public ConfigIndWithMachineCodeMsg() {
    }

    public ConfigIndWithMachineCodeMsg(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }
}
