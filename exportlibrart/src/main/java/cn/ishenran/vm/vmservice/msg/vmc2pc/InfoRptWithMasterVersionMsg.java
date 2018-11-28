package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 主控软件版本
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithMasterVersionMsg implements BaseMsg {
    private String masterVer;

    public InfoRptWithMasterVersionMsg() {
    }

    public InfoRptWithMasterVersionMsg(String masterVer) {
        this.masterVer = masterVer;
    }

    public String getMasterVer() {
        return masterVer;
    }

    public void setMasterVer(String masterVer) {
        this.masterVer = masterVer;
    }
}
