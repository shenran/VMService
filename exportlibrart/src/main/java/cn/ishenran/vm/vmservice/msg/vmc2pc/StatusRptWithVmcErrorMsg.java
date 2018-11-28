package cn.ishenran.vm.vmservice.msg.vmc2pc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

import java.util.HashMap;

/**
 * Vmc现在故障状态
 * 最多可发十六个故障代码
 * 关于故障代码 请参考冰山餐机的说明书
 * Created by ning on 2017/3/3.
 */

public class StatusRptWithVmcErrorMsg implements BaseMsg {
    private int errNum;
    private HashMap<Integer, Integer> errCodeMap;

    public StatusRptWithVmcErrorMsg() {
    }

    public StatusRptWithVmcErrorMsg(int errNum, HashMap<Integer, Integer> errCodeMap) {
        this.errNum = errNum;
        this.errCodeMap = errCodeMap;
    }

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public HashMap<Integer, Integer> getErrCodeMap() {
        return errCodeMap;
    }

    public void setErrCodeMap(HashMap<Integer, Integer> errCodeMap) {
        this.errCodeMap = errCodeMap;
    }
}
