// IVmcMsgObserver.aidl
package cn.ishenran.vm.vmservice;


// Declare any non-default types here with import statements
import cn.ishenran.vm.vmservice.ISendCallBack;
import cn.ishenran.vm.vmservice.IReceiveCallBack;
interface IVmcMsgService {
    void sendMsg(int msgType,String msgBody);
    void sendMsgWithCallBack(int msgType,String msgBody,ISendCallBack cb);
    void registerCallback(IReceiveCallBack cb);
    void unregisterCallback(IReceiveCallBack cb);
}
