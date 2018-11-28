package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 设置连续购买个数
 * Created by ning on 2017/3/23.
 */

public class ConfigIndWithSaleMaxNumMsg implements BaseMsg {
    //连续购买个数
    private int maxNum;

    public ConfigIndWithSaleMaxNumMsg() {
    }

    public ConfigIndWithSaleMaxNumMsg(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
}
