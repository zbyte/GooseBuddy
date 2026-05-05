package android.car.navigation;


import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class CarNavigationInstrumentCluster implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface ClusterType {
    }

    public static final int CLUSTER_TYPE_CUSTOM_IMAGES_SUPPORTED = 1;
    public static final int CLUSTER_TYPE_IMAGE_CODES_ONLY = 2;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarNavigationInstrumentCluster createFromParcel(Parcel in) {
            return new CarNavigationInstrumentCluster(in);
        }

        public CarNavigationInstrumentCluster[] newArray(int size) {
            return new CarNavigationInstrumentCluster[size];
        }
    };
    private final Bundle mExtra;
    private final int mImageColorDepthBits;
    private final int mImageHeight;
    private final int mImageWidth;
    private int mMinIntervalMillis;
    private final int mType;

    private CarNavigationInstrumentCluster(int minIntervalMillis, int type, int imageWidth, int imageHeight, int imageColorDepthBits) {
        this.mMinIntervalMillis = minIntervalMillis;
        this.mType = type;
        this.mImageWidth = imageWidth;
        this.mImageHeight = imageHeight;
        this.mImageColorDepthBits = imageColorDepthBits;
        this.mExtra = new Bundle();
    }

    public CarNavigationInstrumentCluster(CarNavigationInstrumentCluster that) {
        this(that.mMinIntervalMillis, that.mType, that.mImageWidth, that.mImageHeight, that.mImageColorDepthBits);
    }

    private CarNavigationInstrumentCluster(Parcel in) {
        this.mMinIntervalMillis = in.readInt();
        this.mType = in.readInt();
        this.mImageWidth = in.readInt();
        this.mImageHeight = in.readInt();
        this.mImageColorDepthBits = in.readInt();
        this.mExtra = in.readBundle(this.getClass().getClassLoader());
    }

    public static CarNavigationInstrumentCluster createCluster(int minIntervalMillis) {
        return new CarNavigationInstrumentCluster(minIntervalMillis, 2, 0, 0, 0);
    }

    public static CarNavigationInstrumentCluster createCustomImageCluster(int minIntervalMs, int imageWidth, int imageHeight, int imageColorDepthBits) {
        return new CarNavigationInstrumentCluster(minIntervalMs, 1, imageWidth, imageHeight, imageColorDepthBits);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getExtra() {
        return this.mExtra;
    }

    public int getImageColorDepthBits() {
        return this.mImageColorDepthBits;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public int getMinIntervalMillis() {
        return this.mMinIntervalMillis;
    }

    public int getType() {
        return this.mType;
    }

    public boolean supportsCustomImages() {
        return this.mType == 1;
    }

    @Override
    public String toString() {
        return "CarNavigationInstrumentCluster{ minIntervalMillis: " + this.mMinIntervalMillis + ", type: " + this.mType + ", imageWidth: " + this.mImageWidth + ", imageHeight: " + this.mImageHeight + ", imageColourDepthBits: " + this.mImageColorDepthBits + "extra: " + this.mExtra + " }";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mMinIntervalMillis);
        dest.writeInt(this.mType);
        dest.writeInt(this.mImageWidth);
        dest.writeInt(this.mImageHeight);
        dest.writeInt(this.mImageColorDepthBits);
        dest.writeBundle(this.mExtra);
    }
}

