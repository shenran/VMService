package cn.ishenran.vm.lib;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public interface Encoder {
    void WaitWrite();
    ArrayList<byte[]> getWriteMessageQueue();
    Integer encode(JSONObject message);
}
