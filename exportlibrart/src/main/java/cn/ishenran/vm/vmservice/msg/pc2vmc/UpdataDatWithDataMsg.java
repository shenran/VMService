package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 升级包数据
 * Created by ning on 2017/4/6.
 */

public class UpdataDatWithDataMsg implements BaseMsg{
    private int packNum;
    private byte[] updatata_dat;

    public UpdataDatWithDataMsg() {
    }

    public UpdataDatWithDataMsg(int packNum, byte[] updatata_dat) {
        this.packNum = packNum;
        this.updatata_dat = updatata_dat;
    }

    public int getPackNum() {
        return packNum;
    }

    public void setPackNum(int packNum) {
        this.packNum = packNum;
    }

    public byte[] getUpdatata_dat() {
        return updatata_dat;
    }

    public void setUpdatata_dat(byte[] updatata_dat) {
        this.updatata_dat = updatata_dat;
    }
}
