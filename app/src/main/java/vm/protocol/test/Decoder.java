package vm.protocol.test;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;


/**
 * 本类需要继承cn.ishenran.vm.lib.Decoder接口
 * 实现相应的方法，以便由驱动管理器调用
 */

public class Decoder implements cn.ishenran.vm.lib.Decoder{
    public Decoder() {
        super();
    }

    /**
     *
     * @param bytes
     * @return
     *
     * 解码器
     */

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

    /**
     *
     * @param rev
     * @return
     * 回调同步器
     */
    @Override
    public Integer getCallFunById(JSONObject rev) {
        return rev.getInteger("SN");
    }

    /**
     *
     * @param bytes
     * @param len
     * @param message
     * @return
     * 消息拼接器
     */
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
