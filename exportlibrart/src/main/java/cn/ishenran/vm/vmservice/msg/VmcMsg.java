package cn.ishenran.vm.vmservice.msg;

/**
 * Created by ning on 2017/3/10.
 */

public class VmcMsg {
    private int msgType;
    private String msgBody;

    public VmcMsg() {
    }

    public VmcMsg(int msgType, String msgBody) {
        this.msgType = msgType;
        this.msgBody = msgBody;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }
}
