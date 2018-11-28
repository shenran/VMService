package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 货道售空状态
 * Created by ning on 2017/4/6.
 */

public class StatusRptWithChannelSoldMsg implements BaseMsg {
    /**未售空*/
    public static final int NOT_SOLD_OUT = 0;
    /**售空*/
    public static final int SOLD_OUT = 1;

    private int columnNum;
    private HashMap<Integer, Integer> soldMap;

    public StatusRptWithChannelSoldMsg() {
    }

    public StatusRptWithChannelSoldMsg(int columnNum, HashMap<Integer, Integer> soldMap) {
        this.columnNum = columnNum;
        this.soldMap = soldMap;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getSoldMap() {
        return soldMap;
    }

    public void setSoldMap(HashMap<Integer, Integer> soldMap) {
        this.soldMap = soldMap;
    }
}
