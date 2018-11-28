package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 加热/制冷 库内 ON/OFF温度
 * Created by ning on 2017/3/29.
 */

public class GetInfoIndWithRoomOnOffTemp implements BaseMsg {
    /**加热库内ON/OFF温度*/
    public static final int TYPE_HEAT_ON_OFF_TEMP = 37;
    /**制冷库内ON/OFF温度*/
    public static final int TYPE_COMPRESSOR_ON_OFF_TEMP = 38;

    private int type;
    private int roomNo;

    public GetInfoIndWithRoomOnOffTemp() {
    }

    public GetInfoIndWithRoomOnOffTemp(int type, int roomNo) {
        this.type = type;
        this.roomNo = roomNo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}
