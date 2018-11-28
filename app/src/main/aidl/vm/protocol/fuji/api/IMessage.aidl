// IMessage.aidl
package vm.protocol.fuji.api;
import vm.protocol.fuji.api.IConfigIndMsg;
import vm.protocol.fuji.api.IControlIndMsg;
import vm.protocol.fuji.api.ICostIndMsg;
import vm.protocol.fuji.api.IGetInfoMsg;
import vm.protocol.fuji.api.IGetStatusMsg;
import vm.protocol.fuji.api.IVendoutIndMsg;
// Declare any non-default types here with import statements

interface IMessage {

          IConfigIndMsg VMConfig();
          IControlIndMsg VMControl();
          ICostIndMsg VMCost();
          IGetInfoMsg VMGetInfo();
          IGetStatusMsg VMGetStatus();
          IVendoutIndMsg VMVendout();

}
