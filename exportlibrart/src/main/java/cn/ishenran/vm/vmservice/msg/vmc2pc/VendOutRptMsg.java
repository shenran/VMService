package cn.ishenran.vm.vmservice.msg.vmc2pc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc出货报告
 * Created by ning on 2017/3/3.
 */

public class VendOutRptMsg implements BaseMsg {
    public static final int TYPE_COST = 1;
    /**
     * 出货成功
     */
    public static final int STATUS_VENDOUT_SUCC = 1;
    public static final int STATUS_VENDOUT_FAIL = 0;


    private int number;
    private String time;
    private int type;
    private int cashCost;
    private int cardCost;
    private int status;
    private int colnmnNo;
    private int spid;

    public VendOutRptMsg() {
    }

    public VendOutRptMsg(int number, String time, int type, int cashCost, int cardCost, int status, int colnmnNo, int spid) {
        this.number = number;
        this.time = time;
        this.type = type;
        this.cashCost = cashCost;
        this.cardCost = cardCost;
        this.status = status;
        this.colnmnNo = colnmnNo;
        this.spid = spid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCashCost() {
        return cashCost;
    }

    public void setCashCost(int cashCost) {
        this.cashCost = cashCost;
    }

    public int getCardCost() {
        return cardCost;
    }

    public void setCardCost(int cardCost) {
        this.cardCost = cardCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getColnmnNo() {
        return colnmnNo;
    }

    public void setColnmnNo(int colnmnNo) {
        this.colnmnNo = colnmnNo;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }
}

