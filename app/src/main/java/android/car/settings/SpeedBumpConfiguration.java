package android.car.settings;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Objects;

public final class SpeedBumpConfiguration implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SpeedBumpConfiguration createFromParcel(Parcel in) {
            return new SpeedBumpConfiguration(in);
        }

        public SpeedBumpConfiguration[] newArray(int size) {
            return new SpeedBumpConfiguration[size];
        }
    };
    private final double mAcquiredPermitsPerSecond;
    private final double mMaxPermitPool;
    private final long mPermitFillDelay;

    public SpeedBumpConfiguration(double permitsPerSecond, double maxPermitPool, long permitFillDelay) {
        this.mAcquiredPermitsPerSecond = permitsPerSecond;
        this.mMaxPermitPool = maxPermitPool;
        this.mPermitFillDelay = permitFillDelay;
    }

    private SpeedBumpConfiguration(Parcel in) {
        this.mAcquiredPermitsPerSecond = in.readDouble();
        this.mMaxPermitPool = in.readDouble();
        this.mPermitFillDelay = in.readLong();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(!(object instanceof SpeedBumpConfiguration)) {
            return false;
        }
        double f = ((SpeedBumpConfiguration)object).getAcquiredPermitsPerSecond();
        if(this.mAcquiredPermitsPerSecond == f) {
            double f1 = ((SpeedBumpConfiguration)object).getMaxPermitPool();
            if(this.mMaxPermitPool == f1) {
                long v = ((SpeedBumpConfiguration)object).getPermitFillDelay();
                return this.mPermitFillDelay == v;
            }
        }
        return false;
    }

    public double getAcquiredPermitsPerSecond() {
        return this.mAcquiredPermitsPerSecond;
    }

    public double getMaxPermitPool() {
        return this.mMaxPermitPool;
    }

    public long getPermitFillDelay() {
        return this.mPermitFillDelay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{((double)this.mAcquiredPermitsPerSecond), ((double)this.mMaxPermitPool), ((long)this.mPermitFillDelay)});
    }

    @Override
    public String toString() {
        return String.format("[acquired_permits_per_second: %f, max_permit_pool: %f, permit_fill_delay: %d]", ((double)this.mAcquiredPermitsPerSecond), ((double)this.mMaxPermitPool), ((long)this.mPermitFillDelay));
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel desk, int flags) {
        desk.writeDouble(this.mAcquiredPermitsPerSecond);
        desk.writeDouble(this.mMaxPermitPool);
        desk.writeLong(this.mPermitFillDelay);
    }
}

