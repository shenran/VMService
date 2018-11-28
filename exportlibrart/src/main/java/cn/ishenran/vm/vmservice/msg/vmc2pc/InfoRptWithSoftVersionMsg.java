package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 智能控制盒软件版本
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithSoftVersionMsg implements BaseMsg {
    //智能控制盒软件版本
    private String softVer;

    public InfoRptWithSoftVersionMsg() {
    }

    public InfoRptWithSoftVersionMsg(String softVer) {
        this.softVer = softVer;
    }

    public String getSoftVer() {
        return softVer;
    }

    public void setSoftVer(String softVer) {
        this.softVer = softVer;
    }
}
