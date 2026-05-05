package android.car.hardware;


import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.SparseArray;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CarPropertyConfig implements Parcelable {
    public static class AreaConfig implements Parcelable {
        public static final Parcelable.Creator CREATOR = AreaConfig.getCreator(Object.class);
        private final Object mMaxValue;
        private final Object mMinValue;

        private AreaConfig(Parcel in) {
            this.mMinValue = in.readValue(this.getClass().getClassLoader());
            this.mMaxValue = in.readValue(this.getClass().getClassLoader());
        }

        private AreaConfig(Object object0, Object object1) {
            this.mMinValue = object0;
            this.mMaxValue = object1;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private static Parcelable.Creator getCreator(Class class0) {
            return new Parcelable.Creator() {
                public AreaConfig createFromParcel(Parcel source) {
                    return new AreaConfig(source, null);
                }

                public AreaConfig[] newArray(int size) {
                    return (AreaConfig[])Array.newInstance(class0, size);
                }
            };
        }

        public Object getMaxValue() {
            return this.mMaxValue;
        }

        public Object getMinValue() {
            return this.mMinValue;
        }

        @Override
        public String toString() {
            return "CarAreaConfig{mMinValue=" + this.mMinValue + ", mMaxValue=" + this.mMaxValue + '}';
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(this.mMinValue);
            dest.writeValue(this.mMaxValue);
        }
    }

    public static class Builder {
        private int mAccess;
        private final int mAreaType;
        private int mChangeMode;
        private final ArrayList mConfigArray;
        private String mConfigString;
        private float mMaxSampleRate;
        private float mMinSampleRate;
        private final int mPropertyId;
        private final SparseArray mSupportedAreas;
        private final Class mType;

        private Builder(int areaCapacity, int areaType, int propertyId, Class class0) {
            this.mAreaType = areaType;
            this.mConfigArray = new ArrayList();
            this.mPropertyId = propertyId;
            this.mSupportedAreas = areaCapacity == 0 ? new SparseArray() : new SparseArray(areaCapacity);
            this.mType = class0;
        }

        public Builder addArea(int areaId) {
            return this.addAreaConfig(areaId, null, null);
        }

        public Builder addAreaConfig(int areaId, Object object0, Object object1) {
            if(object0 == null && object1 == null) {
                this.mSupportedAreas.put(areaId, null);
                return this;
            }
            AreaConfig carPropertyConfig$AreaConfig0 = new AreaConfig(object0, object1);
            this.mSupportedAreas.put(areaId, carPropertyConfig$AreaConfig0);
            return this;
        }

        public Builder addAreas(int[] areaIds) {
            for(int v = 0; v < areaIds.length; ++v) {
                this.mSupportedAreas.put(areaIds[v], null);
            }
            return this;
        }

        public CarPropertyConfig build() {
            return new CarPropertyConfig(this.mAccess, this.mAreaType, this.mChangeMode, this.mConfigArray, this.mConfigString, this.mMaxSampleRate, this.mMinSampleRate, this.mPropertyId, this.mSupportedAreas, this.mType);
        }

        public Builder setAccess(int access) {
            this.mAccess = access;
            return this;
        }

        public Builder setChangeMode(int changeMode) {
            this.mChangeMode = changeMode;
            return this;
        }

        public Builder setConfigArray(ArrayList arrayList0) {
            this.mConfigArray.clear();
            this.mConfigArray.addAll(arrayList0);
            return this;
        }

        public Builder setConfigString(String configString) {
            this.mConfigString = configString;
            return this;
        }

        public Builder setMaxSampleRate(float maxSampleRate) {
            this.mMaxSampleRate = maxSampleRate;
            return this;
        }

        public Builder setMinSampleRate(float minSampleRate) {
            this.mMinSampleRate = minSampleRate;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarPropertyConfig createFromParcel(Parcel in) {
            return new CarPropertyConfig(in);
        }

        public CarPropertyConfig[] newArray(int size) {
            return new CarPropertyConfig[size];
        }
    };
    private final int mAccess;
    private final int mAreaType;
    private final int mChangeMode;
    private final ArrayList mConfigArray;
    private final String mConfigString;
    private final float mMaxSampleRate;
    private final float mMinSampleRate;
    private final int mPropertyId;
    private final SparseArray mSupportedAreas;
    private final Class mType;

    private CarPropertyConfig(int access, int areaType, int changeMode, ArrayList arrayList0, String configString, float maxSampleRate, float minSampleRate, int propertyId, SparseArray sparseArray0, Class class0) {
        this.mAccess = access;
        this.mAreaType = areaType;
        this.mChangeMode = changeMode;
        this.mConfigArray = arrayList0;
        this.mConfigString = configString;
        this.mMaxSampleRate = maxSampleRate;
        this.mMinSampleRate = minSampleRate;
        this.mPropertyId = propertyId;
        this.mSupportedAreas = sparseArray0;
        this.mType = class0;
    }

    private CarPropertyConfig(Parcel in) {
        this.mAccess = in.readInt();
        this.mAreaType = in.readInt();
        this.mChangeMode = in.readInt();
        int v = in.readInt();
        this.mConfigArray = new ArrayList(v);
        for(int i = 0; i < v; ++i) {
            Integer integer0 = in.readInt();
            this.mConfigArray.add(integer0);
        }
        this.mConfigString = in.readString();
        this.mMaxSampleRate = in.readFloat();
        this.mMinSampleRate = in.readFloat();
        this.mPropertyId = in.readInt();
        int v3 = in.readInt();
        this.mSupportedAreas = new SparseArray(v3);
        for(int i = 0; i < v3; ++i) {
            int v4 = in.readInt();
            AreaConfig area = (AreaConfig)in.readParcelable(this.getClass().getClassLoader());
            this.mSupportedAreas.put(v4, area);
        }
        String s = in.readString();
        try {
            this.mType = Class.forName(s);
        }
        catch(ClassNotFoundException unused_ex) {
            throw new IllegalArgumentException("Class not found: " + s);
        }
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccess() {
        return this.mAccess;
    }

    public int getAreaCount() {
        return this.mSupportedAreas.size();
    }

    public int[] getAreaIds() {
        int[] areaIds = new int[this.mSupportedAreas.size()];
        for(int i = 0; i < areaIds.length; ++i) {
            areaIds[i] = this.mSupportedAreas.keyAt(i);
        }
        return areaIds;
    }

    public int getAreaType() {
        return this.mAreaType;
    }

    public int getChangeMode() {
        return this.mChangeMode;
    }

    public List getConfigArray() {
        return Collections.unmodifiableList(this.mConfigArray);
    }

    public String getConfigString() {
        return this.mConfigString;
    }

    public int getFirstAndOnlyAreaId() {
        if(this.mSupportedAreas.size() != 1) {
            throw new IllegalStateException("Expected one and only area in this property. Prop: 0x" + Integer.toHexString(this.mPropertyId));
        }
        return this.mSupportedAreas.keyAt(0);
    }

    public float getMaxSampleRate() {
        return this.mMaxSampleRate;
    }

    public Object getMaxValue() {
        AreaConfig area = (AreaConfig)this.mSupportedAreas.valueAt(0);
        return area == null ? null : area.getMaxValue();
    }

    public Object getMaxValue(int areaId) {
        AreaConfig area = (AreaConfig)this.mSupportedAreas.get(areaId);
        return area == null ? null : area.getMaxValue();
    }

    public float getMinSampleRate() {
        return this.mMinSampleRate;
    }

    public Object getMinValue() {
        AreaConfig area = (AreaConfig)this.mSupportedAreas.valueAt(0);
        return area == null ? null : area.getMinValue();
    }

    public Object getMinValue(int areaId) {
        AreaConfig area = (AreaConfig)this.mSupportedAreas.get(areaId);
        return area == null ? null : area.getMinValue();
    }

    public int getPropertyId() {
        return this.mPropertyId;
    }

    public Class getPropertyType() {
        return this.mType;
    }

    public boolean hasArea(int areaId) {
        return this.mSupportedAreas.indexOfKey(areaId) >= 0;
    }

    public boolean isGlobalProperty() {
        return this.mAreaType == 0;
    }

    public static Builder newBuilder(Class class0, int propertyId, int areaType) {
        return new Builder(0, areaType, propertyId, class0);
    }

    public static Builder newBuilder(Class class0, int propertyId, int areaType, int areaCapacity) {
        return new Builder(areaCapacity, areaType, propertyId, class0);
    }

    @Override
    public String toString() {
        return "CarPropertyConfig{mPropertyId=" + this.mPropertyId + ", mAccess=" + this.mAccess + ", mAreaType=" + this.mAreaType + ", mChangeMode=" + this.mChangeMode + ", mConfigArray=" + this.mConfigArray + ", mConfigString=" + this.mConfigString + ", mMaxSampleRate=" + this.mMaxSampleRate + ", mMinSampleRate=" + this.mMinSampleRate + ", mSupportedAreas=" + this.mSupportedAreas + ", mType=" + this.mType + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mAccess);
        dest.writeInt(this.mAreaType);
        dest.writeInt(this.mChangeMode);
        dest.writeInt(this.mConfigArray.size());
        for(int i = 0; i < this.mConfigArray.size(); ++i) {
            dest.writeInt(((Integer)this.mConfigArray.get(i)).intValue());
        }
        dest.writeString(this.mConfigString);
        dest.writeFloat(this.mMaxSampleRate);
        dest.writeFloat(this.mMinSampleRate);
        dest.writeInt(this.mPropertyId);
        dest.writeInt(this.mSupportedAreas.size());
        for(int i = 0; i < this.mSupportedAreas.size(); ++i) {
            dest.writeInt(this.mSupportedAreas.keyAt(i));
            dest.writeParcelable(((Parcelable)this.mSupportedAreas.valueAt(i)), flags);
        }
        dest.writeString(this.mType.getName());
    }
}

