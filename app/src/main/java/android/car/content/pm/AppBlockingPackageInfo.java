package android.car.content.pm;


import android.content.pm.Signature;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;


public class AppBlockingPackageInfo implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConstrcutorFlags {
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public AppBlockingPackageInfo createFromParcel(Parcel in) {
            return new AppBlockingPackageInfo(in);
        }

        public AppBlockingPackageInfo[] newArray(int size) {
            return new AppBlockingPackageInfo[size];
        }
    };
    public static final int FLAG_SYSTEM_APP = 1;
    public static final int FLAG_WHOLE_ACTIVITY = 2;
    public final String[] activities;
    public final int flags;
    public final int maxRevisionCode;
    public final int minRevisionCode;
    public final String packageName;
    public final Signature[] signatures;

    public AppBlockingPackageInfo(Parcel in) {
        this.packageName = in.readString();
        this.flags = in.readInt();
        this.minRevisionCode = in.readInt();
        this.maxRevisionCode = in.readInt();
        this.signatures = (Signature[])in.createTypedArray(Signature.CREATOR);
        this.activities = in.createStringArray();
        this.verify();
    }

    public AppBlockingPackageInfo(String packageName, int minRevisionCode, int maxRevisionCode, int flags, Signature[] signatures, String[] activities) {
        if(packageName == null) {
            throw new IllegalArgumentException("packageName cannot be null");
        }
        this.packageName = packageName;
        this.flags = flags;
        this.minRevisionCode = minRevisionCode;
        this.maxRevisionCode = maxRevisionCode;
        this.signatures = signatures;
        this.activities = activities;
        this.verify();
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
        if(!Arrays.equals(this.activities, ((AppBlockingPackageInfo)obj).activities)) {
            return false;
        }
        if(this.flags != ((AppBlockingPackageInfo)obj).flags) {
            return false;
        }
        if(this.maxRevisionCode != ((AppBlockingPackageInfo)obj).maxRevisionCode) {
            return false;
        }
        if(this.minRevisionCode != ((AppBlockingPackageInfo)obj).minRevisionCode) {
            return false;
        }
        if(this.packageName == null) {
            return ((AppBlockingPackageInfo)obj).packageName == null ? Arrays.equals(this.signatures, ((AppBlockingPackageInfo)obj).signatures) : false;
        }
        return this.packageName.equals(((AppBlockingPackageInfo)obj).packageName) ? Arrays.equals(this.signatures, ((AppBlockingPackageInfo)obj).signatures) : false;
    }

    @Override
    public int hashCode() {
        int v = ((((0x1F + Arrays.hashCode(this.activities)) * 0x1F + this.flags) * 0x1F + this.maxRevisionCode) * 0x1F + this.minRevisionCode) * 0x1F;
        return this.packageName == null ? v * 0x1F + Arrays.hashCode(this.signatures) : (v + this.packageName.hashCode()) * 0x1F + Arrays.hashCode(this.signatures);
    }

    public boolean isActivityCovered(String className) {
        if((this.flags & 2) != 0) {
            return true;
        }
        if(this.activities == null) {
            return false;
        }
        String[] arr_s = this.activities;
        for(int v = 0; v < arr_s.length; ++v) {
            if(arr_s[v].equals(className)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "AppBlockingPackageInfo [packageName=" + this.packageName + ", flags=" + this.flags + ", minRevisionCode=" + this.minRevisionCode + ", maxRevisionCode=" + this.maxRevisionCode + ", signatures=" + Arrays.toString(this.signatures) + ", activities=" + Arrays.toString(this.activities) + "]";
    }

    public void verify() throws IllegalArgumentException {
        if(this.signatures == null && (this.flags & 1) == 0) {
            throw new IllegalArgumentException("Only system package with FLAG_SYSTEM_APP can have null signatures");
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.packageName);
        dest.writeInt(this.flags);
        dest.writeInt(this.minRevisionCode);
        dest.writeInt(this.maxRevisionCode);
        dest.writeTypedArray(this.signatures, 0);
        dest.writeStringArray(this.activities);
    }
}

