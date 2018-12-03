package cn.ishenran.vm.lib;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;

public interface Decoder {
    JSONObject decode(byte[] bytes);
    Integer getCallFunById(JSONObject rev);
    boolean getDataByte(byte[] bytes,int len,ByteArrayOutputStream message);
}
