package com.android.car.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CarRatedListeners {
    protected long mLastUpdateTime;
    private final Map mListenersToRate;
    private int mUpdateRate;

    protected CarRatedListeners(int rate) {
        this.mListenersToRate = new HashMap(4);
        this.mLastUpdateTime = -1L;
        this.mUpdateRate = rate;
    }

    public boolean addAndUpdateRate(Object object0, int updateRate) {
        Integer oldUpdateRate = (Integer)this.mListenersToRate.put(object0, Integer.valueOf(updateRate));
        if(this.mUpdateRate > updateRate) {
            this.mUpdateRate = updateRate;
            return true;
        }
        if(oldUpdateRate != null && ((int)oldUpdateRate) == this.mUpdateRate) {
            this.mUpdateRate = (int)(((Integer)Collections.min(this.mListenersToRate.values())));
        }
        return false;
    }

    public boolean contains(Object object0) {
        return this.mListenersToRate.containsKey(object0);
    }

    public Collection getListeners() {
        return this.mListenersToRate.keySet();
    }

    public int getRate() {
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
        Integer updateRate = (Integer)Collections.min(this.mListenersToRate.values());
        if(((int)updateRate) != this.mUpdateRate) {
            this.mUpdateRate = (int)updateRate;
            return true;
        }
        return false;
    }
}

