package cn.ishenran.vm.vmcservice;

import android.os.Parcel;
import android.os.Parcelable;

public class VmcServiceApi implements Parcelable {
    protected VmcServiceApi(Parcel in) {
    }

    public static final Creator<VmcServiceApi> CREATOR = new Creator<VmcServiceApi>() {
        @Override
        public VmcServiceApi createFromParcel(Parcel in) {
            return new VmcServiceApi(in);
        }

        @Override
        public VmcServiceApi[] newArray(int size) {
            return new VmcServiceApi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
