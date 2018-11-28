package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc请求配置
 * Created by ning on 2017/4/6.
 */

public class GetConfDataWithTypeMsg implements BaseMsg {
    /**请求系统时间*/
    public static final int TYPE_VMC_TIME = 2;
    /**请求货道单价现金信息*/
    public static final int TYPE_CASH_PRICE = 3;
    /**请求货道非现金单价信息*/
    public static final int TYPE_CARD_PRICE = 4;
    /**请求货道商品编码信息*/
    public static final int TYPE_SPID = 5;

    private int type;

    public GetConfDataWithTypeMsg() {
    }

    public GetConfDataWithTypeMsg(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
