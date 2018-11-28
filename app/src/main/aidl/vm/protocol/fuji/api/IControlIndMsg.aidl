// IControlIndMsg.aidl
package vm.protocol.fuji.api;

// Declare any non-default types here with import statements

interface IControlIndMsg {
   /**
        * 退币操作
        *
        * @return
        */
       String createType2() ;

       String createType6(int method, int clumnNum, int spid) ;
}
