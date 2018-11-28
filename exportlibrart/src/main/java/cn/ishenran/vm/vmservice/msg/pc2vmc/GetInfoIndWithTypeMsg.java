package cn.ishenran.vm.vmservice.msg.pc2vmc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 获取Vmc信息
 * Vmc上报对应type的Info_RPT
 * Created by ning on 2017/3/6.
 */

public class GetInfoIndWithTypeMsg implements BaseMsg {
    /**VMC的系统参数*/
    public static final int TYPE_VMC_SYS_PARAM = 1;
    /**VMC能力*/
    public static final int TYPE_VMC_POWER = 2;
    /**VMC时间*/
    public static final int TYPE_VMC_TIME = 3;
    /**货道冷热模式*/
    public static final int TYPE_CHANNEL_HOT_COLD_MODE = 4;
    /**货道现金单价*/
    public static final int TYPE_CASH_PRICE = 5;
    /**货道非现金单价*/
    public static final int TYPE_CARD_PRICE = 6;
    /**货道商品编码*/
    public static final int TYPE_SPID = 7;
    /**连续购买个数*/
    public static final int TYPE_SALE_MAX_NUM = 8;
    /**智能控制盒软件版本*/
    public static final int TYPE_VSI_VERSION = 10;
    /**机器编号*/
    public static final int TYPE_MACHINE_CODE = 13;
    /**库内冷热模式*/
    public static final int TYPE_ROOM_HOT_COLD_MODE = 19;
    /**累计销售信息*/
    public static final int TYPE_SALE_INFO = 20;
    /**各货道期间合计销售个数*/
    public static final int TYPE_SALE_NUM = 21;
    /**各货道期间合计销售金额*/
    public static final int TYPE_SALE_MONEY = 22;
    /**主控软件版本*/
    public static final int TYPE_MST_VERSION = 29;
    /**照明动作模式*/
    public static final int TYPE_LAMP_MODE = 30;
    /**加热节电时间带*/
    public static final int TYPE_HEATER_TIME = 34;
    /**制冷节电时间带*/
    public static final int TYPE_COMPRESSOR_TIME = 35;


    private int type;

    public GetInfoIndWithTypeMsg() {
    }

    public GetInfoIndWithTypeMsg(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
