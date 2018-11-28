package cn.ishenran.vm.vmservice.msg.vmc2pc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * VMC时间
 * Created by ning on 2017/3/2.
 */

public class InfoRptWithVmcTimeMsg implements BaseMsg {
    private String time;

    public InfoRptWithVmcTimeMsg() {
    }

    public InfoRptWithVmcTimeMsg(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
