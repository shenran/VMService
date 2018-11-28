package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 制冷库内ON/OFF温度
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithCompressorRoomOnOffTempMsg implements BaseMsg {
    //制冷库内的库号
    private int roomNo;
    //制冷库n的ON/OFF温度
    private int roomTemp;

    public InfoRptWithCompressorRoomOnOffTempMsg() {
    }

    public InfoRptWithCompressorRoomOnOffTempMsg(int roomNo, int roomTemp) {
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
