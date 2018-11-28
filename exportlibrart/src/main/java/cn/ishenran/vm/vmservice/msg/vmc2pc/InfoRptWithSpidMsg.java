package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 货道商品编码
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithSpidMsg implements BaseMsg {
    //货道的个数
    private int columnNum;
    //各货道商品编码
    private HashMap<Integer, Integer> spid;

    public InfoRptWithSpidMsg() {
    }

    public InfoRptWithSpidMsg(int columnNum, HashMap<Integer, Integer> spid) {
        this.columnNum = columnNum;
        this.spid = spid;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getSpid() {
        return spid;
    }

    public void setSpid(HashMap<Integer, Integer> spid) {
        this.spid = spid;
    }
}
