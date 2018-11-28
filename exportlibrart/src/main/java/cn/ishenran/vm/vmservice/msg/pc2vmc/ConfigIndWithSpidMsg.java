package cn.ishenran.vm.vmservice.msg.pc2vmc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 设置货道商品编码
 * Created by ning on 2017/3/6.
 */

public class ConfigIndWithSpidMsg implements BaseMsg {
    //货道个数
    private int columnNum;
    //各货道对应的商品id
    private HashMap<Integer,Integer> spidMap;

    public ConfigIndWithSpidMsg() {
    }

    public ConfigIndWithSpidMsg(int columnNum, HashMap<Integer, Integer> spidMap) {
        this.columnNum = columnNum;
        this.spidMap = spidMap;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getSpidMap() {
        return spidMap;
    }

    public void setSpidMap(HashMap<Integer, Integer> spidMap) {
        this.spidMap = spidMap;
    }
}
