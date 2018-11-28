package cn.ishenran.vm.vmservice.msg.pc2vmc;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 出货查询模式
 * 出货之前检验是否下位机是否可以出货
 * Created by ning on 2017/3/6.
 */

public class VendOutIndWithCheckModeMsg implements BaseMsg {
    /**现金交易类型为1  其余用户自定义交易类型范围 49~239 */
    public static final int TYPE_CASH = 1;

    /**
     * 出货方式：根据商品id出货
     */
    public static final int METHOD_PRODUCT_ID = 1;
    /**
     * 出货方式：根据货道id出货
     */
    public static final int METHOD_CHANNEL_ID = 2;

    private int method;
    private int type;
    private int columnNum;
    private int spid;
    private int cost;

    public VendOutIndWithCheckModeMsg() {
    }

    public VendOutIndWithCheckModeMsg(int method, int type, int columnNum, int spid, int cost) {
        this.method = method;
        this.type = type;
        this.columnNum = columnNum;
        this.spid = spid;
        this.cost = cost;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
