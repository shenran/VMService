package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 各货道合计销售个数
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithChannelSaleNumMsg implements BaseMsg {
    private int columnNum;
    private HashMap<Integer,Integer> saleNum;

    public InfoRptWithChannelSaleNumMsg() {
    }

    public InfoRptWithChannelSaleNumMsg(int columnNum, HashMap<Integer,Integer> saleNum) {
        this.columnNum = columnNum;
        this.saleNum = saleNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer,Integer> getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(HashMap<Integer,Integer> saleNum) {
        this.saleNum = saleNum;
    }
}
