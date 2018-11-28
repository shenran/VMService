package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 扣费指令
 * Created by ning on 2017/3/30.
 */

public class CostIndMsg implements BaseMsg {
    private int type;
    private int machine;
    private int columnNum;
    private int value;

    public CostIndMsg() {
    }

    public CostIndMsg(int type, int machine, int columnNum, int value) {
        this.type = type;
        this.machine = machine;
        this.columnNum = columnNum;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
