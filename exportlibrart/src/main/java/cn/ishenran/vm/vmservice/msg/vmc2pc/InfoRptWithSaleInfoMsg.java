package cn.ishenran.vm.vmservice.msg.vmc2pc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 累计销售信息
 * Created by ning on 2017/3/31.
 */

public class InfoRptWithSaleInfoMsg implements BaseMsg {
    //累计销售个数
    private int saleNum;
    //累计销售金额
    private int saleMoney;
    //累计现金销售个数
    private int saleCashNum;
    //累计现金销售金额
    private int saleCashMoney;
    //累计非现金销售个数
    private int saleCardNum;
    //累计非现金销售金额
    private int saleCardMoney;
    //期间合计销售个数
    private int totalNum;
    //期间合计销售金额
    private int totalMoney;

    public InfoRptWithSaleInfoMsg() {
    }

    public InfoRptWithSaleInfoMsg(int saleNum, int saleMoney, int saleCashNum, int saleCashMoney, int saleCardNum, int saleCardMoney, int totalNum, int totalMoney) {
        this.saleNum = saleNum;
        this.saleMoney = saleMoney;
        this.saleCashNum = saleCashNum;
        this.saleCashMoney = saleCashMoney;
        this.saleCardNum = saleCardNum;
        this.saleCardMoney = saleCardMoney;
        this.totalNum = totalNum;
        this.totalMoney = totalMoney;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(int saleMoney) {
        this.saleMoney = saleMoney;
    }

    public int getSaleCashNum() {
        return saleCashNum;
    }

    public void setSaleCashNum(int saleCashNum) {
        this.saleCashNum = saleCashNum;
    }

    public int getSaleCashMoney() {
        return saleCashMoney;
    }

    public void setSaleCashMoney(int saleCashMoney) {
        this.saleCashMoney = saleCashMoney;
    }

    public int getSaleCardNum() {
        return saleCardNum;
    }

    public void setSaleCardNum(int saleCardNum) {
        this.saleCardNum = saleCardNum;
    }

    public int getSaleCardMoney() {
        return saleCardMoney;
    }

    public void setSaleCardMoney(int saleCardMoney) {
        this.saleCardMoney = saleCardMoney;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
