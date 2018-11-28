// IVendoutIndMsg.aidl
package vm.protocol.fuji.api;

// Declare any non-default types here with import statements

interface IVendoutIndMsg {
    String createMode1(int method, int type, int colunm, int spid, int cost) ;
    String createMode2(int method, int type, int colunm, int spid, int cost) ;
}
