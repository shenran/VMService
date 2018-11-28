package cn.ishenran.vm.vmservice.msg.pc2vmc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 设置货道非现金单价
 * Created by ning on 2017/3/6.
 */

public class ConfigIndWithCardPriceMsg implements BaseMsg {
    //货道个数
    private int columnNum;
    //各货道对应的非现金单价
    private HashMap<Integer,Integer> cardPriceMap;

    public ConfigIndWithCardPriceMsg() {
    }

    public ConfigIndWithCardPriceMsg(int columnNum, HashMap<Integer, Integer> cardPriceMap) {
        this.columnNum = columnNum;
        this.cardPriceMap = cardPriceMap;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getCardPriceMap() {
        return cardPriceMap;
    }

    public void setCardPriceMap(HashMap<Integer, Integer> cardPriceMap) {
        this.cardPriceMap = cardPriceMap;
    }
}
