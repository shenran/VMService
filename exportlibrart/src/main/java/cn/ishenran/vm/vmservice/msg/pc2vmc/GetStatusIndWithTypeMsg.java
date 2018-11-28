package cn.ishenran.vm.vmservice.msg.pc2vmc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 获取Vmc状态信息
 * 根据不同type 下位机上报对应的Status_RPT
 * Created by ning on 2017/3/6.
 */

public class GetStatusIndWithTypeMsg implements BaseMsg {
    /**VMC系统状态*/
    public static final int TYPE_VMC_SYS_STATUS = 1;
    /**VMC现在故障状态*/
    public static final int TYPE_VMC_ERR_STATUS = 2;
    /**货道售空状态*/
    public static final int TYPE_SOLD_OUT_STATUS = 3;
    /**用户投币余额*/
    public static final int TYPE_COIN_BALANCE = 4;
    /**库内温度*/
    public static final int TYPE_ROOM_TEMP = 5;
    /**货道可销售状态*/
    public static final int TYPE_SALE_STATUS = 6;

    private int type;

    public GetStatusIndWithTypeMsg() {
    }

    public GetStatusIndWithTypeMsg(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
