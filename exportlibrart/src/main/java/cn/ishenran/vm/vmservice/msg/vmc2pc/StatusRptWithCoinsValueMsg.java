package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 用户投币余额
 * Created by ning on 2017/4/6.
 */

public class StatusRptWithCoinsValueMsg implements BaseMsg {
    private int value;

    public StatusRptWithCoinsValueMsg() {
    }

    public StatusRptWithCoinsValueMsg(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
