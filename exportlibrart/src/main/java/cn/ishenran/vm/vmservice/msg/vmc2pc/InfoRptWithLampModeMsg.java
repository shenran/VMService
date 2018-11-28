package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 照明动作模式
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithLampModeMsg implements BaseMsg {
    /**关闭*/
    public static final int MODE_OFF = 0;
    /**打开*/
    public static final int MODE_ON = 1;
    /**自动*/
    public static final int MODE_AUTO = 2;

    //照明动作模式
    private int lampMode;

    public InfoRptWithLampModeMsg() {
    }

    public InfoRptWithLampModeMsg(int lampMode) {
        this.lampMode = lampMode;
    }

    public int getLampMode() {
        return lampMode;
    }

    public void setLampMode(int lampMode) {
        this.lampMode = lampMode;
    }
}
