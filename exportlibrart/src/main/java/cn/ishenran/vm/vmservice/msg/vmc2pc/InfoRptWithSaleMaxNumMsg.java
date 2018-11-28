package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 连续购买个数
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithSaleMaxNumMsg implements BaseMsg {
    //连上购买个数
    private int saleMaxNum;

    public InfoRptWithSaleMaxNumMsg() {
    }

    public InfoRptWithSaleMaxNumMsg(int saleMaxNum) {
        this.saleMaxNum = saleMaxNum;
    }

    public int getSaleMaxNum() {
        return saleMaxNum;
    }

    public void setSaleMaxNum(int saleMaxNum) {
        this.saleMaxNum = saleMaxNum;
    }
}
