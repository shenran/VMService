package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc系统配置报告
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithSystemConfigMsg implements BaseMsg {
    /**饮料机*/
    public static final int MACHINE_TYPE_DRINK = 1;
    /**Twistar*/
    public static final int MACHINE_TYPE_TWISTAR = 2;

    //售货机机种
    private int machineType;
    //售货机实际货道数
    private int columnNum;

    public InfoRptWithSystemConfigMsg() {
    }

    public InfoRptWithSystemConfigMsg(int machineType, int columnNum) {
        this.machineType = machineType;
        this.columnNum = columnNum;
    }

    public int getMachineType() {
        return machineType;
    }

    public void setMachineType(int machineType) {
        this.machineType = machineType;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }
}
