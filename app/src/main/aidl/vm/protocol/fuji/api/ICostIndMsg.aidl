// ICostIndMsg.aidl
package vm.protocol.fuji.api;

// Declare any non-default types here with import statements

interface ICostIndMsg {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   String createCostInd(int type, int machine, int column, int value);
}
