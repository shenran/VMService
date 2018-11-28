package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 各货道合计销售金额
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithChannelSaleMoneyMsg implements BaseMsg {
    //货道的个数
    private int columnNum;
    //各货道的销售金额
    private HashMap<Integer, Integer> saleMoney;

    public InfoRptWithChannelSaleMoneyMsg() {
    }

    public InfoRptWithChannelSaleMoneyMsg(int columnNum, HashMap<Integer, Integer> saleMoney) {
        this.columnNum = columnNum;
        this.saleMoney = saleMoney;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(HashMap<Integer, Integer> saleMoney) {
        this.saleMoney = saleMoney;
    }
}
