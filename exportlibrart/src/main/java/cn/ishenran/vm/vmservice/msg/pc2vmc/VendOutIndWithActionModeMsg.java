package cn.ishenran.vm.vmservice.msg.pc2vmc;

import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * 出货动作指令
 * Created by ning on 2017/3/15.
 */

public class VendOutIndWithActionModeMsg implements BaseMsg {
    /**
     * 现金交易类型为1  其余用户自定义交易类型范围 49~239
     */
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
    private int colunmNO;
    private int spid;
    private int cost;

    public VendOutIndWithActionModeMsg() {
    }

    public VendOutIndWithActionModeMsg(int method, int type, int colunmNO, int spid, int cost) {
        this.method = method;
        this.type = type;
        this.colunmNO = colunmNO;
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

    public int getColunmNO() {
        return colunmNO;
    }

    public void setColunmNO(int colunmNO) {
        this.colunmNO = colunmNO;
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
