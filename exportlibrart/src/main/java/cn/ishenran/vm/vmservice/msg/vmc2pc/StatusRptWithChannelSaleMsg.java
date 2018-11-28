package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 货道可销售状态
 * Created by ning on 2017/4/6.
 */

public class StatusRptWithChannelSaleMsg implements BaseMsg {
    private int columnNum;
    private HashMap<Integer, Integer> saleMap;

    public StatusRptWithChannelSaleMsg() {
    }

    public StatusRptWithChannelSaleMsg(int columnNum, HashMap<Integer, Integer> saleMap) {
        this.columnNum = columnNum;
        this.saleMap = saleMap;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getSaleMap() {
        return saleMap;
    }

    public void setSaleMap(HashMap<Integer, Integer> saleMap) {
        this.saleMap = saleMap;
    }
}
