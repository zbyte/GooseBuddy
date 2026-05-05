package com.android.car.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CarRatedFloatListeners {
    protected long mLastUpdateTime;
    private final Map mListenersToRate;
    private float mUpdateRate;

    protected CarRatedFloatListeners(float rate) {
        this.mListenersToRate = new HashMap(4);
        this.mLastUpdateTime = -1L;
        this.mUpdateRate = rate;
    }

    public boolean addAndUpdateRate(Object object0, float updateRate) {
        Float oldUpdateRate = (Float)this.mListenersToRate.put(object0, Float.valueOf(updateRate));
        if((this.mUpdateRate < updateRate)) {
            this.mUpdateRate = updateRate;
            return true;
        }
        if(oldUpdateRate != null && ((float)oldUpdateRate) == this.mUpdateRate) {
            this.mUpdateRate = (float)(((Float)Collections.max(this.mListenersToRate.values())));
        }
        return false;
    }

    public boolean contains(Object object0) {
        return this.mListenersToRate.containsKey(object0);
    }

    public Collection getListeners() {
        return this.mListenersToRate.keySet();
    }

    public float getRate() {
        return this.mUpdateRate;
    }

    public boolean isEmpty() {
        return this.mListenersToRate.isEmpty();
    }

    public boolean remove(Object object0) {
        this.mListenersToRate.remove(object0);
        if(this.mListenersToRate.isEmpty()) {
            return false;
        }
        Float updateRate = (Float)Collections.max(this.mListenersToRate.values());
        if(((float)updateRate) != this.mUpdateRate) {
            this.mUpdateRate = (float)updateRate;
            return true;
        }
        return false;
    }
}

