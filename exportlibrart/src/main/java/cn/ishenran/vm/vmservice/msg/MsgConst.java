package cn.ishenran.vm.vmservice.msg;

/**
 * Created by ning on 2017/3/7.
 */

public class MsgConst {
    //===========================上位机指令=================================================
    /**设置货道非现金单价*/
    public static final int PC2VMC_CONFIGIND_WITH_CARD_PRICE = 1000;
    /**设置货道现金单价*/
    public static final int PC2VMC_CONFIGIND_WITH_CASH_PRICE = 1001;
    /**设置制冷库内ON/OFF温度*/
    public static final int PC2VMC_CONFIGIND_WITH_COMPRESSOR_ON_OFF_TEMP = 1002;
    /**设置制冷节电时间带*/
    public static final int PC2VMC_CONFIGIND_WITH_COMPRESSOR_TIME = 1003;
    /** 设置加热库内ON/OFF温度*/
    public static final int PC2VMC_CONFIGIND_WITH_HOT_ON_OFF_TEMP = 1004;
    /** 设置加热节电时间带*/
    public static final int PC2VMC_CONFIGIND_WITH_HOT_TIME = 1005;
    /**设置照明动作模式*/
    public static final int PC2VMC_CONFIGIND_WITH_LAMP_MODE = 1006;
    /**设置机器编号*/
    public static final int PC2VMC_CONFIGIND_WITH_MACHINE_CODE = 1007;
    /**设置连续购买个数*/
    public static final int PC2VMC_CONFIGIND_WITH_SALE_MAX_NUM = 1008;
    /**设置货道商品编码*/
    public static final int PC2VMC_CONFIGIND_WITH_SPID = 1009;
    /**设置VMC时间*/
    public static final int PC2VMC_CONFIGIND_WITH_VMC_TIME = 1010;

    /**扣费指令*/
    public static final int PC2VMC_CONSTIND = 1011;

    /**退币操作*/
    public static final int PC2VMC_CONTROLIND_WITH_COIN_BACK = 1012;
    /**指示Vmc选货*/
    public static final int PC2VMC_CONTROLIND_WITH_SELECT_PRODUCT = 1013;

    /**加热/制冷 库内 ON/OFF温度*/
    public static final int PC2VMC_GETINFOIND_WITH_ROOM_ON_OFF_TEMP = 1014;
    /**获取Vmc信息*/
    public static final int PC2VMC_GETINFOIND_WITH_TYPE = 1015;

    /**获取Vmc状态信息*/
    public static final int PC2VMC_GETSTATUSIND_WITH_TYPE = 1016;

    /**升级包数据*/
    public static final int PC2VMC_UPDATADAT_WITH_DATA = 1017;
    /**升级包标记*/
    public static final int PC2VMC_UPDATADAT_WITH_MARK = 1018;

    /**出货动作指令*/
    public static final int PC2VMC_VENDOUTIND_WITH_ACTION_MODE = 1019;
    /**出货查询模式*/
    public static final int PC2VMC_VENDOUTIND_WITH_CHECK_MODE = 1020;


    //===========================下位机报告=================================================
    /**Vmc启动状态报告*/
    public static final int VMC2PC_ACTIONRPT_WITH_START_STATUS = 2000;
    /**出货完成事件*/
    public static final int VMC2PC_ACTIONRPT_WITH_VENDOUT_STATUS = 2001;
    /**退币开关报告*/
    public static final int VMC2PC_BUTTONRPT_WITH_COIN_BACK = 2002;
    /**用户按键报告*/
    public static final int VMC2PC_BUTTONRPT_WITH_USER_DOEN = 2003;
    /**现金扣费报告*/
    public static final int VMC2PC_COSTRPT = 2004;
    /**Vmc请求配置*/
    public static final int VMC2PC_GETCONFDATA_WITH_TYPE = 2005;
    /**请求获取升级包数据*/
    public static final int VMC2PC_GETUPDATA_WITH_DATA = 2006;
    /**请求获取升级包标记*/
    public static final int VMC2PC_GETUPDATA_WITH_MARK = 2007;
    /**货道冷热模式*/
    public static final int VMC2PC_INFORPT_WITH_CHANNEL_HOT_COLD_MODE = 2008;
    /**各货道合计销售金额*/
    public static final int VMC2PC_INFORPT_WITH_CHANNEL_SALE_MONEY = 2009;
    /**各货道合计销售个数*/
    public static final int VMC2PC_INFORPT_WITH_CHANNEL_SALE_NUM = 2010;
    /** 加热库内ON/OFF温度*/
    public static final int VMC2PC_INFORPT_WITH_HOT_ROOM_ON_OFF_TEMP = 2011;
    /**加热节电时间带*/
    public static final int VMC2PC_INFORPT_WITH_HOT_TIME = 2012;
    /** 制冷库内ON/OFF温度*/
    public static final int VMC2PC_INFORPT_WITH_COMPRESSOR_ROOM_ON_OFF_TEMP = 2013;
    /**制冷节电时间带*/
    public static final int VMC2PC_INFORPT_WITH_COMPRESSOR_TIME = 2014;
    /**Vmc系统配置报告*/
    public static final int VMC2PC_INFORPT_WITH_SYSTEM_CONFIG = 2015;
    /**照明动作模式*/
    public static final int VMC2PC_INFORPT_WITH_LAMP_MODE = 2016;
    /**机器编号*/
    public static final int VMC2PC_INFORPT_WITH_MACHINE_CODE = 2017;
    /**主控软件版本*/
    public static final int VMC2PC_INFORPT_WITH_MASTER_VERSION = 2018;
    /**库内冷热模式*/
    public static final int VMC2PC_INFORPT_WITH_ROOM_HOT_COLD_MODE= 2019;
    /**累计销售信息*/
    public static final int VMC2PC_INFORPT_WITH_SALE_INFO = 2020;
    /**连续购买个数*/
    public static final int VMC2PC_INFORPT_WITH_SALE_MAX_NUM = 2021;
    /**智能控制盒软件版本*/
    public static final int VMC2PC_INFORPT_WITH_SOFT_VERSION = 2022;
    /**货道商品编码*/
    public static final int VMC2PC_INFORPT_WITH_SPID = 2023;
    /**Vmc能力*/
    public static final int VMC2PC_INFORPT_WITH_VMC_POWER = 2024;
    /**VMC时间*/
    public static final int VMC2PC_INFORPT_WITH_VMC_TIME = 2025;
    /**货道非现金单价*/
    public static final int VMC2PC_INFORPT_WITH_CHANNEL_CARD_PRICE = 2026;
    /**货道现金单价*/
    public static final int VMC2PC_INFORPT_WITH_CHANNEL_CASH_PRICE = 2027;


    /**进入/退出维护模式*/
    public static final int VMC2PC_SERVICERPT_WITH_ENG_MODE = 2028;
    /**Vmc门开关事件*/
    public static final int VMC2PC_SERVICERPT_WITH_DOOW_SW = 2029;
    /**维护按键报告*/
    public static final int VMC2PC_SERVICERPT_WITH_ENG_BUTTON = 2030;

    /**货道可销售状态*/
    public static final int VMC2PC_STATUSRPT_WITH_CHANNEL_SALE = 2031;
    /**货道售空状态*/
    public static final int VMC2PC_STATUSRPT_WITH_CHANNEL_SOLD = 2032;
    /**用户投币余额*/
    public static final int VMC2PC_STATUSRPT_WITH_COINS_VALUE = 2033;
    /**库内温度*/
    public static final int VMC2PC_STATUSRPT_WITH_ROOM_TEMP = 2034;
    /**Vmc系统状态报告*/
    public static final int VMC2PC_STATUSRPT_WITH_SYSTEM_STATUS = 2035;
    /**Vmc现在故障状态*/
    public static final int VMC2PC_STATUSRPT_WITH_VMC_ERROR = 2036;

    /**Vmc出货报告*/
    public static final int VMC2PC_VENDOUTRPT = 2037;


}
