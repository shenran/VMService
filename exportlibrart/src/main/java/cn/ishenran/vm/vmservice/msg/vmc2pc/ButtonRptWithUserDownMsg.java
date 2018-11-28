package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 用户按键报告
 * Created by ning on 2017/4/6.
 */

public class ButtonRptWithUserDownMsg implements BaseMsg {
    private int columnNo;
    private int spid;

    public ButtonRptWithUserDownMsg() {
    }

    public ButtonRptWithUserDownMsg(int columnNo, int spid) {
        this.columnNo = columnNo;
        this.spid = spid;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }
}
