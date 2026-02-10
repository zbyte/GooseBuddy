package com.yftech.car.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarData implements Parcelable {
    public static class CarDataEntry implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        private final String mKey;
        private final String mValue;

        static {
            CarDataEntry.CREATOR = new Parcelable.Creator() {
                public CarDataEntry createFromParcel(Parcel in) {
                    return new CarDataEntry(in);
                }

                public CarDataEntry[] newArray(int size) {
                    return new CarDataEntry[size];
                }
            };
        }

        public CarDataEntry(Parcel in) {
            this.mKey = in.readString();
            this.mValue = in.readString();
        }

        public CarDataEntry(String key, byte value) {
            this(key, String.valueOf(value));
        }

        public CarDataEntry(String key, double value) {
            this(key, String.valueOf(value));
        }

        public CarDataEntry(String key, float value) {
            this(key, String.valueOf(value));
        }

        public CarDataEntry(String key, int value) {
            this(key, String.valueOf(value));
        }

        public CarDataEntry(String key, long value) {
            this(key, String.valueOf(value));
        }

        public CarDataEntry(String key, String value) {
            if(key == null) {
                throw new IllegalArgumentException("key is null");
            }
            this.mKey = key;
            this.mValue = value;
        }

        public CarDataEntry(String key, short value) {
            this(key, String.valueOf(value));
        }

        public CarDataEntry(String key, boolean value) {
            this(key, String.valueOf(value));
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getKey() {
            return this.mKey;
        }

        public boolean getValueBoolean() {
            return Boolean.parseBoolean(this.mValue);
        }

        public byte getValueByte() {
            return Byte.parseByte(this.mValue);
        }

        public double getValueDouble() {
            return Double.parseDouble(this.mValue);
        }

        public float getValueFloat() {
            return Float.parseFloat(this.mValue);
        }

        public int getValueInt() {
            return Integer.parseInt(this.mValue);
        }

        public long getValueLong() {
            return Long.parseLong(this.mValue);
        }

        public short getValueShort() {
            return Short.parseShort(this.mValue);
        }

        public String getValueString() {
            return this.mValue;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.mKey);
            dest.writeString(this.mValue);
        }
    }

    public static final Parcelable.Creator CREATOR;
    private Map mDataMap;

    static {
        CarData.CREATOR = new Parcelable.Creator() {
            public CarData createFromParcel(Parcel in) {
                return new CarData(in);
            }

            public CarData[] newArray(int size) {
                return new CarData[size];
            }
        };
    }

    public CarData() {
        this.mDataMap = new HashMap();
    }

    public CarData(Parcel parcel) {
        this.mDataMap = new HashMap();
        this.mDataMap = new HashMap();
        int v = parcel.readInt();
        if(v > 0) {
            for(int i = 0; i < v; ++i) {
                CarDataEntry entry = new CarDataEntry(parcel);
                this.mDataMap.put(entry.getKey(), entry);
            }
        }
    }

    public CarData(CarDataEntry dataEntry) {
        this.mDataMap = new HashMap();
        this.addDataEntry(dataEntry);
    }

    public CarData(Collection collection0) {
        this.mDataMap = new HashMap();
        if(collection0 != null && collection0.size() != 0) {
            for(Object object0: collection0) {
                this.addDataEntry(((CarDataEntry)object0));
            }
        }
    }

    public CarData addDataEntry(CarDataEntry dataEntry) {
        if(dataEntry == null) {
            return this;
        }
        this.mDataMap.put(dataEntry.getKey(), dataEntry);
        return this;
    }

    public CarData addDataEntry(List list0) {
        if(list0 != null && list0.size() != 0) {
            for(Object object0: list0) {
                this.addDataEntry(((CarDataEntry)object0));
            }
        }
        return this;
    }

    public boolean containsKey(String key) {
        return this.mDataMap.containsKey(key);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Collection getDataCollection() {
        return this.mDataMap.values();
    }

    public CarDataEntry getDataEntry(String key) {
        return (CarDataEntry)this.mDataMap.get(key);
    }

    public CarData removeDataEntry(CarDataEntry dataEntry) {
        if(dataEntry == null) {
            return this;
        }
        this.mDataMap.remove(dataEntry.getKey());
        return this;
    }

    public CarData removeDataEntry(List list0) {
        if(list0 != null && list0.size() != 0) {
            for(Object object0: list0) {
                this.removeDataEntry(((CarDataEntry)object0));
            }
        }
        return this;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if(this.mDataMap == null) {
            dest.writeInt(-1);
        }
        else {
            dest.writeInt(this.mDataMap.size());
        }
        for(Object object0: this.mDataMap.values()) {
            ((CarDataEntry)object0).writeToParcel(dest, 0);
        }
    }
}

