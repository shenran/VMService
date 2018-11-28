package cn.ishenran.vm.vmservice.msg.pc2vmc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 设置货道现金单价
 * Created by ning on 2017/3/6.
 */

public class ConfigIndWithCashPriceMsg implements BaseMsg {
    //货道个数
    private int cloumnNum;
    //各货道对象的现价单价
    private HashMap<Integer,Integer> cashPriceMap;

    public ConfigIndWithCashPriceMsg() {
    }

    public ConfigIndWithCashPriceMsg(int cloumnNum, HashMap<Integer, Integer> cashPriceMap) {
        this.cloumnNum = cloumnNum;
        this.cashPriceMap = cashPriceMap;
    }

    public int getCloumnNum() {
        return cloumnNum;
    }

    public void setCloumnNum(int cloumnNum) {
        this.cloumnNum = cloumnNum;
    }

    public HashMap<Integer, Integer> getCashPriceMap() {
        return cashPriceMap;
    }

    public void setCashPriceMap(HashMap<Integer, Integer> cashPriceMap) {
        this.cashPriceMap = cashPriceMap;
    }
}
