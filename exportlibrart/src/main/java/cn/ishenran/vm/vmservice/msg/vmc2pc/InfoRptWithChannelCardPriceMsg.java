package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * 货道非现金单价
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithChannelCardPriceMsg implements BaseMsg {
    //货道的个数
    private int columnNum;
    //各货道非现金单价
    private HashMap<Integer, Integer> cardPrice;

    public InfoRptWithChannelCardPriceMsg() {
    }

    public InfoRptWithChannelCardPriceMsg(int columnNum, HashMap<Integer, Integer> cardPrice) {
        this.columnNum = columnNum;
        this.cardPrice = cardPrice;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public HashMap<Integer, Integer> getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(HashMap<Integer, Integer> cardPrice) {
        this.cardPrice = cardPrice;
    }
}
