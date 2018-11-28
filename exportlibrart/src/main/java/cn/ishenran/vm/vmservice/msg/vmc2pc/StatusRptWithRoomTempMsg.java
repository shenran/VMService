package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 库内温度
 * Created by ning on 2017/4/6.
 */

public class StatusRptWithRoomTempMsg implements BaseMsg {
    private int room1_temp;
    private int room2_temp;
    private int room3_temp;

    public StatusRptWithRoomTempMsg() {
    }

    public StatusRptWithRoomTempMsg(int room1_temp, int room2_temp, int room3_temp) {
        this.room1_temp = room1_temp;
        this.room2_temp = room2_temp;
        this.room3_temp = room3_temp;
    }

    public int getRoom1_temp() {
        return room1_temp;
    }

    public void setRoom1_temp(int room1_temp) {
        this.room1_temp = room1_temp;
    }

    public int getRoom2_temp() {
        return room2_temp;
    }

    public void setRoom2_temp(int room2_temp) {
        this.room2_temp = room2_temp;
    }

    public int getRoom3_temp() {
        return room3_temp;
    }

    public void setRoom3_temp(int room3_temp) {
        this.room3_temp = room3_temp;
    }
}
