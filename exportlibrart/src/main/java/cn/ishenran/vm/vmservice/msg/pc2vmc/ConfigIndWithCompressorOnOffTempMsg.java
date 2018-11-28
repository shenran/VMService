package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 设置制冷库内ON/OFF温度
 * Created by ning on 2017/3/23.
 */

public class ConfigIndWithCompressorOnOffTempMsg implements BaseMsg {
    /**设置加热库内的库号 1~3*/
    private int roomNo;
    /**加热库n的ON/OFF温度 -9℃~70℃*/
    private int temp;

    public ConfigIndWithCompressorOnOffTempMsg() {
    }

    public ConfigIndWithCompressorOnOffTempMsg(int roomNo, int temp) {
        this.roomNo = roomNo;
        this.temp = temp;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
