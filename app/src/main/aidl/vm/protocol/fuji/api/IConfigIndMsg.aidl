// IConfigIndMsg.aidl
package vm.protocol.fuji.api;

// Declare any non-default types here with import statements

interface IConfigIndMsg {
    /**
     * 设置vmc时间
     *
     * @return
     */
    String createModel2();

       /**
        * 设置连续购买个数
        * @param saleMaxNum
        * @return
        */
       String createModel6(int saleMaxNum) ;

       /**
        * 设置货道商品编码
        *
        * @param spids
        * @return
        */
       String createModel5(int columnNum, in Map spids) ;

       /**
        * 设置货道现金单价
        *
        * @param columnNum
        * @param prices
        * @return
        */
       String createModel3(int columnNum, in Map prices) ;

       /**
        * 设置货道非现金单价
        *
        * @param columnNum
        * @param prices
        * @return
        */
       String createModel4(int columnNum, in Map prices) ;

       /**
        * 设置机器编号
        *
        * @param machineId
        * @return
        */
       String createModel8(String machineId) ;

       /**
        * 设置照明动作模式
        *
        * @param lampMode
        * @return
        */
       String createModel15(int lampMode) ;

       /**
        * 设置加热节电时间带
        *
        * @param startHour
        * @param startMin
        * @param endHour
        * @param endMin
        * @return
        */
       String createModel19(int startHour, int startMin, int endHour, int endMin) ;

       /**
        * 设置制冷节电时间带
        *
        * @param startHour
        * @param startMin
        * @param endHour
        * @param endMin
        * @return
        */
       String createModel20(int startHour, int startMin, int endHour, int endMin) ;

       /**
        * 设置加热库内ON/OFF温度
        *
        * @param roomNo
        * @param temp
        * @return
        */
       String createModel22(int roomNo, int temp) ;

       /**
        * 设置制冷库内ON/OFF温度
        *
        * @param roomNo
        * @param temp
        * @return
        */
       String createModel23(int roomNo, int temp);
}
