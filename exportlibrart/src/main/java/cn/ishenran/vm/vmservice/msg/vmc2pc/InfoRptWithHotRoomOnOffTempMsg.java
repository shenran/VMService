package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 加热库内ON/OFF温度
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithHotRoomOnOffTempMsg implements BaseMsg{
    //加热库内的库号
    private int roomNo;
    //加热库n的ON/OFF温度
    private int roomTemp;

    public InfoRptWithHotRoomOnOffTempMsg() {
    }

    public InfoRptWithHotRoomOnOffTempMsg(int roomNo, int roomTemp) {
        this.roomNo = roomNo;
        this.roomTemp = roomTemp;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomTemp() {
        return roomTemp;
    }

    public void setRoomTemp(int roomTemp) {
        this.roomTemp = roomTemp;
    }
}
