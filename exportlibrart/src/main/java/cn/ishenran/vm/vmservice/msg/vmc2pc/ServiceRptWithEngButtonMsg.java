package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 维护按键报告
 * Created by ning on 2017/3/31.
 */

public class ServiceRptWithEngButtonMsg implements BaseMsg {
    /**表示1#按键按下*/
    public static final int BUTTON_DOWN = 1;

    //按键号
    private int buttonNum;

    public ServiceRptWithEngButtonMsg() {
    }

    public ServiceRptWithEngButtonMsg(int buttonNum) {
        this.buttonNum = buttonNum;
    }

    public int getButtonNum() {
        return buttonNum;
    }

    public void setButtonNum(int buttonNum) {
        this.buttonNum = buttonNum;
    }
}
