package cn.ishenran.vm.vmservice.observer;


import cn.ishenran.vm.vmservice.msg.BaseMsg;

/**
 * Created by ning on 2016/11/16.
 */

public interface VmcBaseObserver {
    void notify(BaseMsg msg);
}
