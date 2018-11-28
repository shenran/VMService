package cn.ishenran.vm.vmservice.util;


import com.alibaba.fastjson.JSON;

import cn.ishenran.vm.vmservice.msg.BaseMsg;
import cn.ishenran.vm.vmservice.msg.MsgConst;
import cn.ishenran.vm.vmservice.msg.VmcMsg;

import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithCardPriceMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithCashPriceMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithCompressorOnOffTempMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithCompressorTimeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithHotOnOffTempMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithHotTimeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithLampModeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithMachineCodeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithSaleMaxNumMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithSpidMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ConfigIndWithVmcTimeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.CostIndMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ControlIndWithCoinBackMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.ControlIndWithSelectProductMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.GetInfoIndWithRoomOnOffTemp;
import cn.ishenran.vm.vmservice.msg.pc2vmc.GetInfoIndWithTypeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.GetStatusIndWithTypeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.UpdataDatWithDataMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.UpdataDatWithMarkMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.VendOutIndWithActionModeMsg;
import cn.ishenran.vm.vmservice.msg.pc2vmc.VendOutIndWithCheckModeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ActionRptWithStartStatusMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ActionRptWithVendOutStatusMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ButtonRptWithCoinBackMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ButtonRptWithUserDownMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.CostRptMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.GetConfDataWithTypeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.GetUpdataWithDataMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.GetUpdataWithMarkMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithChannelCardPriceMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithChannelCashPriceMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithChannelHotColdModeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithChannelSaleMoneyMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithChannelSaleNumMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithCompressorRoomOnOffTempMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithCompressorTimeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithHotRoomOnOffTempMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithHotTimeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithLampModeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithMachineCodeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithMasterVersionMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithRoomHotColdModeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithSaleInfoMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithSaleMaxNumMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithSoftVersionMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithSpidMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithSystemConfigMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithVmcPowerMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.InfoRptWithVmcTimeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ServiceRptWihtEngModeMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ServiceRptWithDoorSwMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.ServiceRptWithEngButtonMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.StatusRptWithChannelSaleMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.StatusRptWithChannelSoldMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.StatusRptWithCoinsValueMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.StatusRptWithRoomTempMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.StatusRptWithSystemStatusMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.StatusRptWithVmcErrorMsg;
import cn.ishenran.vm.vmservice.msg.vmc2pc.VendOutRptMsg;


/**
 * 消息处理工具类
 * <p>
 * Created by ning on 2017/3/8.
 */

public class MsgUtil {
    /**
     * 将Vmc的消息解码
     *
     * @param msgType
     * @param msgBody
     * @return null or msg
     */
    public static BaseMsg decodeVmcMsg(int msgType, String msgBody) {
        BaseMsg msg = null;
        switch (msgType) {
            case MsgConst.VMC2PC_ACTIONRPT_WITH_START_STATUS:
                msg = JSON.parseObject(msgBody, ActionRptWithStartStatusMsg.class);
                break;
            case MsgConst.VMC2PC_ACTIONRPT_WITH_VENDOUT_STATUS:
                msg = JSON.parseObject(msgBody, ActionRptWithVendOutStatusMsg.class);
                break;
            case MsgConst.VMC2PC_BUTTONRPT_WITH_COIN_BACK:
                msg = JSON.parseObject(msgBody, ButtonRptWithCoinBackMsg.class);
                break;
            case MsgConst.VMC2PC_BUTTONRPT_WITH_USER_DOEN:
                msg = JSON.parseObject(msgBody, ButtonRptWithUserDownMsg.class);
                break;
            case MsgConst.VMC2PC_COSTRPT:
                msg = JSON.parseObject(msgBody, CostRptMsg.class);
                break;
            case MsgConst.VMC2PC_GETCONFDATA_WITH_TYPE:
                msg = JSON.parseObject(msgBody, GetConfDataWithTypeMsg.class);
                break;
            case MsgConst.VMC2PC_GETUPDATA_WITH_DATA:
                msg = JSON.parseObject(msgBody, GetUpdataWithDataMsg.class);
                break;
            case MsgConst.VMC2PC_GETUPDATA_WITH_MARK:
                msg = JSON.parseObject(msgBody, GetUpdataWithMarkMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_CHANNEL_HOT_COLD_MODE:
                msg = JSON.parseObject(msgBody, InfoRptWithChannelHotColdModeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_CHANNEL_SALE_MONEY:
                msg = JSON.parseObject(msgBody, InfoRptWithChannelSaleMoneyMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_CHANNEL_SALE_NUM:
                msg = JSON.parseObject(msgBody, InfoRptWithChannelSaleNumMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_HOT_ROOM_ON_OFF_TEMP:
                msg = JSON.parseObject(msgBody, InfoRptWithHotRoomOnOffTempMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_HOT_TIME:
                msg = JSON.parseObject(msgBody, InfoRptWithHotTimeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_COMPRESSOR_ROOM_ON_OFF_TEMP:
                msg = JSON.parseObject(msgBody, InfoRptWithCompressorRoomOnOffTempMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_COMPRESSOR_TIME:
                msg = JSON.parseObject(msgBody, InfoRptWithCompressorTimeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_SYSTEM_CONFIG:
                msg = JSON.parseObject(msgBody, InfoRptWithSystemConfigMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_LAMP_MODE:
                msg = JSON.parseObject(msgBody, InfoRptWithLampModeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_MACHINE_CODE:
                msg = JSON.parseObject(msgBody, InfoRptWithMachineCodeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_MASTER_VERSION:
                msg = JSON.parseObject(msgBody, InfoRptWithMasterVersionMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_ROOM_HOT_COLD_MODE:
                msg = JSON.parseObject(msgBody, InfoRptWithRoomHotColdModeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_SALE_INFO:
                msg = JSON.parseObject(msgBody, InfoRptWithSaleInfoMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_SALE_MAX_NUM:
                msg = JSON.parseObject(msgBody, InfoRptWithSaleMaxNumMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_SOFT_VERSION:
                msg = JSON.parseObject(msgBody, InfoRptWithSoftVersionMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_SPID:
                msg = JSON.parseObject(msgBody, InfoRptWithSpidMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_VMC_POWER:
                msg = JSON.parseObject(msgBody, InfoRptWithVmcPowerMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_VMC_TIME:
                msg = JSON.parseObject(msgBody, InfoRptWithVmcTimeMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_CHANNEL_CARD_PRICE:
                msg = JSON.parseObject(msgBody, InfoRptWithChannelCardPriceMsg.class);
                break;
            case MsgConst.VMC2PC_INFORPT_WITH_CHANNEL_CASH_PRICE:
                msg = JSON.parseObject(msgBody, InfoRptWithChannelCashPriceMsg.class);
                break;
            case MsgConst.VMC2PC_SERVICERPT_WITH_ENG_MODE:
                msg = JSON.parseObject(msgBody, ServiceRptWihtEngModeMsg.class);
                break;
            case MsgConst.VMC2PC_SERVICERPT_WITH_DOOW_SW:
                msg = JSON.parseObject(msgBody, ServiceRptWithDoorSwMsg.class);
                break;
            case MsgConst.VMC2PC_SERVICERPT_WITH_ENG_BUTTON:
                msg = JSON.parseObject(msgBody, ServiceRptWithEngButtonMsg.class);
                break;
            case MsgConst.VMC2PC_STATUSRPT_WITH_CHANNEL_SALE:
                msg = JSON.parseObject(msgBody, StatusRptWithChannelSaleMsg.class);
                break;
            case MsgConst.VMC2PC_STATUSRPT_WITH_CHANNEL_SOLD:
                msg = JSON.parseObject(msgBody, StatusRptWithChannelSoldMsg.class);
                break;
            case MsgConst.VMC2PC_STATUSRPT_WITH_COINS_VALUE:
                msg = JSON.parseObject(msgBody, StatusRptWithCoinsValueMsg.class);
                break;
            case MsgConst.VMC2PC_STATUSRPT_WITH_ROOM_TEMP:
                msg = JSON.parseObject(msgBody, StatusRptWithRoomTempMsg.class);
                break;
            case MsgConst.VMC2PC_STATUSRPT_WITH_SYSTEM_STATUS:
                msg = JSON.parseObject(msgBody, StatusRptWithSystemStatusMsg.class);
                break;
            case MsgConst.VMC2PC_STATUSRPT_WITH_VMC_ERROR:
                msg = JSON.parseObject(msgBody, StatusRptWithVmcErrorMsg.class);
                break;
            case MsgConst.VMC2PC_VENDOUTRPT:
                msg = JSON.parseObject(msgBody, VendOutRptMsg.class);
                break;


        }
        return msg;
    }

    public static VmcMsg encodeVmcMsg(BaseMsg baseMsg) {
        VmcMsg msg = null;
        if (baseMsg instanceof ConfigIndWithCardPriceMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_CARD_PRICE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithCashPriceMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_CASH_PRICE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithCompressorOnOffTempMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_COMPRESSOR_ON_OFF_TEMP, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithCompressorTimeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_COMPRESSOR_TIME, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithHotOnOffTempMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_HOT_ON_OFF_TEMP, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithHotTimeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_HOT_TIME, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithLampModeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_LAMP_MODE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithMachineCodeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_MACHINE_CODE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithSaleMaxNumMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_SALE_MAX_NUM, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithSpidMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_SPID, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ConfigIndWithVmcTimeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONFIGIND_WITH_VMC_TIME, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof CostIndMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONSTIND, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ControlIndWithCoinBackMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONTROLIND_WITH_COIN_BACK, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof ControlIndWithSelectProductMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_CONTROLIND_WITH_SELECT_PRODUCT, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof GetInfoIndWithRoomOnOffTemp) {
            msg = new VmcMsg(MsgConst.PC2VMC_GETINFOIND_WITH_ROOM_ON_OFF_TEMP, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof GetInfoIndWithTypeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_GETINFOIND_WITH_TYPE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof GetStatusIndWithTypeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_GETSTATUSIND_WITH_TYPE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof UpdataDatWithDataMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_UPDATADAT_WITH_DATA, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof UpdataDatWithMarkMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_UPDATADAT_WITH_MARK, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof VendOutIndWithActionModeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_VENDOUTIND_WITH_ACTION_MODE, JSON.toJSONString(baseMsg));
        } else if (baseMsg instanceof VendOutIndWithCheckModeMsg) {
            msg = new VmcMsg(MsgConst.PC2VMC_VENDOUTIND_WITH_CHECK_MODE, JSON.toJSONString(baseMsg));
        }

        return msg;
    }
}
