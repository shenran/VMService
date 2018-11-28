package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 货道冷热模式
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithChannelHotColdModeMsg implements BaseMsg {
    /**制冷*/
    public static final int COLD_MODE = 1;
    /**加热*/
    public static final int HOT_MODE = 2;

    //货道的个数
    private int columnNum;
    //各货道冷热模式
    private HashMap<Integer, Integer> hcMode;

    public InfoRptWithChannelHotColdModeMsg() {
    }

    public InfoRptWithChannelHotColdModeMsg(int columnNum, HashMap<Integer, Integer> hcMode) {
        this.columnNum = columnNum;
        this.hcMode = hcMode;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getHcMode() {
        return hcMode;
    }

    public void setHcMode(HashMap<Integer, Integer> hcMode) {
        this.hcMode = hcMode;
    }
}
