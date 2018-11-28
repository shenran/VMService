package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 货道现金单价
 * Created by ning on 2017/4/7.
 */

public class InfoRptWithChannelCashPriceMsg implements BaseMsg {
    //货道的个数
    private int columnNum;
    //各货道现金单价
    private HashMap<Integer, Integer> cashPrice;

    public InfoRptWithChannelCashPriceMsg() {
    }

    public InfoRptWithChannelCashPriceMsg(int columnNum, HashMap<Integer, Integer> cashPrice) {
        this.columnNum = columnNum;
        this.cashPrice = cashPrice;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(HashMap<Integer, Integer> cashPrice) {
        this.cashPrice = cashPrice;
    }
}
