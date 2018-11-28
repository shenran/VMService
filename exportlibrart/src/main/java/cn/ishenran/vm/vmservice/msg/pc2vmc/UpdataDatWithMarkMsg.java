package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 升级包标记
 * Created by ning on 2017/4/6.
 */

public class UpdataDatWithMarkMsg implements BaseMsg{
    private byte[] updata_ini;

    public UpdataDatWithMarkMsg() {
    }

    public UpdataDatWithMarkMsg(byte[] updata_ini) {
        this.updata_ini = updata_ini;
    }

    public byte[] getUpdata_ini() {
        return updata_ini;
    }

    public void setUpdata_ini(byte[] updata_ini) {
        this.updata_ini = updata_ini;
    }
}
