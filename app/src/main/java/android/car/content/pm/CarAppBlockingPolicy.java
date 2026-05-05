package android.car.content.pm;


import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;


public class CarAppBlockingPolicy implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarAppBlockingPolicy createFromParcel(Parcel in) {
            return new CarAppBlockingPolicy(in);
        }

        public CarAppBlockingPolicy[] newArray(int size) {
            return new CarAppBlockingPolicy[size];
        }
    };
    private static final String TAG = "CarAppBlockingPolicy";
    public final AppBlockingPackageInfo[] blacklists;
    private static final Method sReadBlobMethod;
    private static final Method sWriteBlobMethod;
    public final AppBlockingPackageInfo[] whitelists;

    static {
        Method writeBlob;
        Method readBlob;
        try {
            readBlob = Parcel.class.getMethod("readBlob");
            writeBlob = Parcel.class.getMethod("writeBlob", byte[].class);
        }
        catch(NoSuchMethodException unused_ex) {
            readBlob = null;
            writeBlob = null;
        }
        sReadBlobMethod = readBlob;
        sWriteBlobMethod = writeBlob;
    }

    public CarAppBlockingPolicy(Parcel in) {
        byte[] arr_b = in.readBlob();
        Parcel parcel1 = Parcel.obtain();
        parcel1.unmarshall(arr_b, 0, arr_b.length);
        parcel1.setDataPosition(0);
        this.whitelists = (AppBlockingPackageInfo[])parcel1.createTypedArray(AppBlockingPackageInfo.CREATOR);
        this.blacklists = (AppBlockingPackageInfo[])parcel1.createTypedArray(AppBlockingPackageInfo.CREATOR);
        parcel1.recycle();
    }

    public CarAppBlockingPolicy(AppBlockingPackageInfo[] whitelists, AppBlockingPackageInfo[] blacklists) {
        this.whitelists = whitelists;
        this.blacklists = blacklists;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.blacklists, ((CarAppBlockingPolicy)obj).blacklists) ? Arrays.equals(this.whitelists, ((CarAppBlockingPolicy)obj).whitelists) : false;
    }

    @Override
    public int hashCode() {
        return (0x1F + Arrays.hashCode(this.blacklists)) * 0x1F + Arrays.hashCode(this.whitelists);
    }

    @Override
    public String toString() {
        return "CarAppBlockingPolicy [whitelists=" + Arrays.toString(this.whitelists) + ", blacklists=" + Arrays.toString(this.blacklists) + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Parcel parcel1 = Parcel.obtain();
        parcel1.writeTypedArray(this.whitelists, 0);
        parcel1.writeTypedArray(this.blacklists, 0);
        dest.writeBlob(parcel1.marshall());
        parcel1.recycle();
    }
}

