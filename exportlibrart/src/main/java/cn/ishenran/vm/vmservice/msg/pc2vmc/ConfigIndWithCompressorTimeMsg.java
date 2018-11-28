package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 设置制冷节电时间带
 * Created by ning on 2017/3/23.
 */

public class ConfigIndWithCompressorTimeMsg implements BaseMsg {
    //开始时
    private int startHour;
    //开始分
    private int startMinute;
    //结束时
    private int endHour;
    //结束分
    private int endMinute;

    public ConfigIndWithCompressorTimeMsg() {
    }

    public ConfigIndWithCompressorTimeMsg(int startHour, int startMinute, int endHour, int endMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }
}
