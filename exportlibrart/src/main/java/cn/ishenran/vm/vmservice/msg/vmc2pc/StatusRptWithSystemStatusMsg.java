package cn.ishenran.vm.vmservice.msg.vmc2pc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Vmc系统状态报告
 * Created by ning on 2017/3/2.
 */

public class StatusRptWithSystemStatusMsg implements BaseMsg {
    //Vmc销售状态
    private int saleStatus;
    //工作模式
    private int workPattern;
    //门开关状态
    private int doorSw;
    //硬币器连接状态
    private int coinConnection;
    //纸币器连接状态
    private int billConnection;
    //硬币5角缺币状态
    private int cointype0Lack;
    //硬币1元缺币状态
    private int cointype1Lack;
    //纸币器停用状态
    private int billStatus;

    public StatusRptWithSystemStatusMsg() {
    }

    public StatusRptWithSystemStatusMsg(int saleStatus, int workPattern, int doorSw, int coinConnection, int billConnection, int cointype0Lack, int cointype1Lack, int billStatus) {
        this.saleStatus = saleStatus;
        this.workPattern = workPattern;
        this.doorSw = doorSw;
        this.coinConnection = coinConnection;
        this.billConnection = billConnection;
        this.cointype0Lack = cointype0Lack;
        this.cointype1Lack = cointype1Lack;
        this.billStatus = billStatus;
    }

    public int getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(int saleStatus) {
        this.saleStatus = saleStatus;
    }

    public int getWorkPattern() {
        return workPattern;
    }

    public void setWorkPattern(int workPattern) {
        this.workPattern = workPattern;
    }

    public int getDoorSw() {
        return doorSw;
    }

    public void setDoorSw(int doorSw) {
        this.doorSw = doorSw;
    }

    public int getCoinConnection() {
        return coinConnection;
    }

    public void setCoinConnection(int coinConnection) {
        this.coinConnection = coinConnection;
    }

    public int getBillConnection() {
        return billConnection;
    }

    public void setBillConnection(int billConnection) {
        this.billConnection = billConnection;
    }

    public int getCointype0Lack() {
        return cointype0Lack;
    }

    public void setCointype0Lack(int cointype0Lack) {
        this.cointype0Lack = cointype0Lack;
    }

    public int getCointype1Lack() {
        return cointype1Lack;
    }

    public void setCointype1Lack(int cointype1Lack) {
        this.cointype1Lack = cointype1Lack;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }
}
