// IGetInfoMsg.aidl
package vm.protocol.fuji.api;

// Declare any non-default types here with import statements

interface IGetInfoMsg {
   String createTypeModule(int type) ;


   String createRoomModule(int type, int roomNo) ;
}
