package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 现金扣费报告
 * Created by ning on 2017/4/6.
 */

public class CostRptMsg implements BaseMsg {
    private int machine;
    private int column;
    private int value;

    public CostRptMsg() {
    }

    public CostRptMsg(int machine, int column, int value) {
        this.machine = machine;
        this.column = column;
        this.value = value;
    }

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
