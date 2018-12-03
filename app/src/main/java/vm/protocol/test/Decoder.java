package vm.protocol.test;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;




public class Decoder implements cn.ishenran.vm.lib.Decoder{
    public Decoder() {
        super();
    }
    @Override
    public JSONObject decode(byte[] bytes) {
        //Log.d(this.toString(), "decode: "+bytes.toString());



        JSONObject rev=new JSONObject();
        rev.put("Action",bytes[2]);
        if(bytes[3]!=0)
            rev.put("SUC",false);
        else
            rev.put("SUC",true);
        rev.put("SN",bytes[1]);
        //Log.d("Decoder", "decode: "+bytes);
        //bytes.
        //return null;
        return rev;
    }

    @Override
    public Integer getCallFunById(JSONObject rev) {
        return rev.getInteger("SN");
    }

    @Override
    public boolean getDataByte(byte[] bytes,int len,ByteArrayOutputStream message) {


        byte beginByte = 0x12;
        byte endByte = 0x22;
        int messageSize = 0;

        if (message.size() == 0) {
            if (bytes[0] != beginByte && len < 5 && bytes[4] != endByte) {
                message.reset();
                return false;
            } else {
                message.write(bytes, 0, 5);

                return true;
            }
        }

        message.reset();
        return false;
    }
}
