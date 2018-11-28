package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 出货完成事件
 * Created by ning on 2017/3/31.
 */

public class ActionRptWithVendOutStatusMsg implements BaseMsg {
    /**出货成功*/
    public static final int STATUS_VEND_SUCCESS = 1;

    //实际出货货道号
    private int columnNum;
    //出货的商品id
    private int spid;
    //出货执行状态
    private int status;

    public ActionRptWithVendOutStatusMsg() {
    }

    public ActionRptWithVendOutStatusMsg(int columnNum, int spid, int status) {
        this.columnNum = columnNum;
        this.spid = spid;
        this.status = status;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
