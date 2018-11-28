package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 请求获取升级包数据
 * Created by ning on 2017/4/6.
 */

public class GetUpdataWithDataMsg implements BaseMsg {
    private int packNum;

    public GetUpdataWithDataMsg() {
    }

    public GetUpdataWithDataMsg(int packNum) {
        this.packNum = packNum;
    }

    public int getPackNum() {
        return packNum;
    }

    public void setPackNum(int packNum) {
        this.packNum = packNum;
    }
}
