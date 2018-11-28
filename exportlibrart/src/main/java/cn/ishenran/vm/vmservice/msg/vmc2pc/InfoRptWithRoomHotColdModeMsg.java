package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 库内冷热模式
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithRoomHotColdModeMsg implements BaseMsg {
    /**加热模式*/
    public static final int HOT_MODE = 1;
    /**制冷模式*/
    public static final int COLD_MODE = 2;

    private int room1_HCMode;
    private int room2_HCMode;
    private int room3_HCMode;

    public InfoRptWithRoomHotColdModeMsg() {
    }

    public InfoRptWithRoomHotColdModeMsg(int room1_HCMode, int room2_HCMode, int room3_HCMode) {
        this.room1_HCMode = room1_HCMode;
        this.room2_HCMode = room2_HCMode;
        this.room3_HCMode = room3_HCMode;
    }

    public int getRoom1_HCMode() {
        return room1_HCMode;
    }

    public void setRoom1_HCMode(int room1_HCMode) {
        this.room1_HCMode = room1_HCMode;
    }

    public int getRoom2_HCMode() {
        return room2_HCMode;
    }

    public void setRoom2_HCMode(int room2_HCMode) {
        this.room2_HCMode = room2_HCMode;
    }

    public int getRoom3_HCMode() {
        return room3_HCMode;
    }

    public void setRoom3_HCMode(int room3_HCMode) {
        this.room3_HCMode = room3_HCMode;
    }
}
