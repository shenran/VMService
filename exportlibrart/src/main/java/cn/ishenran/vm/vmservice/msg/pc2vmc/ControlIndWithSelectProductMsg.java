package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 指示Vmc选货
 * Created by ning on 2017/3/23.
 */

public class ControlIndWithSelectProductMsg implements BaseMsg {
    //选货方式
    private int method;
    //货道号
    private int columnNum;
    //商品id
    private int spid;

    public ControlIndWithSelectProductMsg() {
    }

    public ControlIndWithSelectProductMsg(int method, int columnNum, int spid) {
        this.method = method;
        this.columnNum = columnNum;
        this.spid = spid;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
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
}
