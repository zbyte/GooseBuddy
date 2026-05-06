package com.yftech.vehicle.internal;

import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;

import com.yftech.car.utils.BinderUtils;
import com.yftech.vehicle.internal.adapter.ICarBsp.DisplayDtc;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.SetItemUnitInfo;
import com.yftech.vehicle.internal.adapter.ICarKey.CarKeyEvent;
import com.yftech.vehicle.internal.adapter.ICarMisc.DeviceNode;
import com.yftech.vehicle.internal.adapter.ICarMisc.ErrorCodeInfo;
import com.yftech.vehicle.internal.adapter.ICarMisc.KeyTestEvent;
import com.yftech.vehicle.internal.project.IProject.PersonalMemoryInfo;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class CarManager {
    class SignalCallback extends ISignalCallback.Stub {
        private SignalCallback() {
        }

        SignalCallback(com.yftech.vehicle.internal.CarManager x1) {
        }

        @Override  // com.yftech.vehicle.internal.ISignalCallback
        public void onValueChanged(int signalId, byte[] value) throws RemoteException {
            Log.d(TAG, "onValueChanged signalId=" + signalId + ", value: " + Arrays.toString(value));
            StringBuffer buf = new StringBuffer();
            for(int i = 0; i < value.length; ++i) {
                buf.append(Integer.toHexString(value[i])).append(", ");
            }
            CarData d = new CarData(value);
            if(d.isDataValue()) {
                byte[] arr_b1 = d.dataValue();
                sendSignalCallback(signalId, arr_b1);
                return;
            }
            Number number0 = d.numberValue();
            sendSignalCallback(signalId, number0);
        }
    }

    class SignalReceiverHolder {
        Method method;
        boolean needSignalId;
        Class paramType;
        Reference receiver;
        Method valueOfMethod;
        boolean valueToEnabledState;

        SignalReceiverHolder(Object receiver, Method method, Class class0, boolean needSignalId, boolean valueToEnabledState) {
            this.receiver = new WeakReference(receiver);
            this.method = method;
            paramType = class0;
            this.needSignalId = needSignalId;
            this.valueToEnabledState = valueToEnabledState;
            if(class0.isEnum() || class0 == CarKeyEvent.class || class0 == KeyTestEvent.class || class0 == ErrorCodeInfo.class || class0 == DeviceNode.class || class0 == SetItemUnitInfo.class || class0 == DisplayDtc.class || class0 == PersonalMemoryInfo.class) {
                try {
                    valueOfMethod = class0.getMethod("valueOf", Integer.TYPE);
                }
                catch(Throwable unused_ex) {
                    try {
                        valueOfMethod = class0.getMethod("valueOf", byte[].class);
                    }
                    catch(Throwable t2) {
                        Log.e(TAG, "SignalReceiverHolder<init> valueOf byte[] error", t2);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj == null) {
                return false;
            }
            if(getClass() != obj.getClass()) {
                return false;
            }
            if(receiver.get() == null) {
                if(((SignalReceiverHolder)obj).receiver.get() != null) {
                    return false;
                }
            }
            else if(!receiver.get().equals(((SignalReceiverHolder)obj).receiver.get())) {
                return false;
            }
            return Objects.equals(method, ((SignalReceiverHolder) obj).method);
        }

        @Override
        public int hashCode() {
            if(receiver == null) {
                return method == null ? 961 : 961 + method.hashCode();
            }
            int v = receiver.hashCode();
            return method == null ? (v + 0x1F) * 0x1F : (v + 0x1F) * 0x1F + method.hashCode();
        }

        @NonNull
        @Override
        public String toString() {
            return "SignalReceiverHolder{receiver=" + receiver.getClass().getSimpleName() + ", method=" + method.getName() + '}';
        }
    }

    private static final String SERVICE_NAME = "yfcarservice";
    private static final String TAG = "GooseCarManager";
    private SignalCallback mCallback;
    private IBinder.DeathRecipient mDeathRecipient;
    private final byte[] mL;
    private static ICarService mService;
    private Map mSignalReceivers;
    private static CarManager sMe;

    private CarManager() {
        mL = new byte[0];
        mDeathRecipient = new IBinder.DeathRecipient() {
            @Override  // android.os.IBinder$DeathRecipient
            public void binderDied() {
                if(CarManager.mService != null) {
                    CarManager.mService.asBinder().unlinkToDeath(this, 0);
                    CarManager.mService = null;
                }
                int count = 0;
                while(count <= 2 && CarManager.mService == null) {
                    try {
                        ++count;
                        Thread.sleep(1000L);
                        getService();
                        StringBuilder stringBuilder0 = new StringBuilder().append("service dead ,mDeathRecipient-> try conn 1000ms-> count =").append(count).append(" mService=");
                        Integer integer0 = CarManager.mService == null ? 0: CarManager.mService.hashCode();
                        Log.w(TAG, stringBuilder0.append(integer0).toString());
                        if(CarManager.mService == null) {
                            continue;
                        }
                        newOrRetryRegisterSignalCallback(null);
                    }
                    catch(InterruptedException unused_ex) {
                        Log.w(TAG, "service dead , try conn sleep 1000ms error !");
                        break;
                    }
                }
            }
        };
        mSignalReceivers = new HashMap();
    }

    public static CarManager get() {
        CarManager carManager0;
        synchronized(CarManager.class) {
            if(CarManager.sMe == null) {
                carManager0 = new CarManager();
                CarManager.sMe = carManager0;
            }
            else {
                carManager0 = CarManager.sMe;
            }
            return carManager0;
        }
    }

    private ICarService getService() {
        return getService(false);
    }

    private ICarService getService(boolean rebind) {
        synchronized(mL) {
            if(CarManager.mService == null || rebind) {
                CarManager.mService = null;
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder(SERVICE_NAME);
                if(iBinder0 != null) {
                    try {
                        iBinder0.linkToDeath(mDeathRecipient, 0);
                        CarManager.mService = com.yftech.vehicle.internal.ICarService.Stub.asInterface(iBinder0);
                    }
                    catch(RemoteException e) {
                        Log.e(TAG, "getService->linkToDeath error, e->" + e.getMessage());
                    }
                }
            }
            return CarManager.mService;
        }
    }

    public byte[] getSignalDataValue(int signalId) {
        return new CarData(getSignalValueInner(signalId)).dataValue();
    }

    public Number getSignalValue(int signalId) {
        return new CarData(getSignalValueInner(signalId)).numberValue();
    }

    private byte[] getSignalValueInner(int signalId) {
        try {
            return getService().getSignalValue(signalId);
        }
        catch(Throwable t) {
            Log.w(TAG, "getSignalValue()", t);
            try {
                return getService(true).getSignalValue(signalId);
            }
            catch(Throwable unused_ex) {
                Log.e(TAG, "getSignalValue() retry", t);
                return null;
            }
        }
    }

    public Number[] getSignalsValue(int[] signalsId) {
        byte[] arr_b = getSignalsValueInner(signalsId);
        if(arr_b != null && arr_b.length == signalsId.length) {
            Number[] values = new Number[arr_b.length];
            CarData data = new CarData(arr_b);
            for(int i = 0; i < values.length; ++i) {
                values[i] = data.numberValue();
                data.next();
            }
            return values;
        }
        return null;
    }

    private byte[] getSignalsValueInner(int[] signalsId) {
        try {
            return getService().getSignalsValue(signalsId);
        }
        catch(Throwable t) {
            Log.w(TAG, "getSignalsValue()", t);
            try {
                return getService(true).getSignalsValue(signalsId);
            }
            catch(Throwable unused_ex) {
                Log.e(TAG, "getSignalsValue() retry", t);
                return null;
            }
        }
    }

    private boolean isObjectsEqual(Object cachedObj, Object receiver) {
        return cachedObj != null && cachedObj.equals(receiver);
    }

    public static boolean isServiceConnected() {
        synchronized(CarManager.class) {
        }
        return CarManager.mService != null;
    }

    private boolean isSystemCalss(String name) {
        return name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.");
    }

    private void newOrRetryRegisterSignalCallback(Map map0) {
        int n = map0 == null ? mSignalReceivers.size() : map0.size();
        if(n > 0) {
            int i = 0;
            int[] signalsId = new int[n];
            for(Object object0: (map0 == null ? mSignalReceivers.keySet() : map0.keySet())) {
                signalsId[i] = (int)(((Integer)object0));
                ++i;
            }
            if(mCallback == null) {
                mCallback = new SignalCallback(this);
            }
            registerSignalCallback(mCallback, signalsId);
            return;
        }
        unregisterSignalCallback(mCallback);
    }

    public void registerReceiver(Object receiver) {
        Class clazz = receiver.getClass();
        HashMap rsTemp = new HashMap();
        while(clazz != null && !isSystemCalss(clazz.getName())) {
            Method[] arr_method = clazz.getDeclaredMethods();
            for(int i = 0; i < arr_method.length; ++i) {
                Method method = arr_method[i];
                SignalReceiver annotation = (SignalReceiver)method.getAnnotation(SignalReceiver.class);
                if(annotation != null) {
                    Class[] arr_class = method.getParameterTypes();
                    int v1 = annotation.signalId();
                    int[] arr_v = annotation.signalsIdArray();
                    boolean needSignalId = arr_v != null && arr_v.length > 0 && arr_v[0] >= 0;
                    if(!needSignalId && v1 >= 0) {
                        arr_v = new int[]{v1};
                    }
                    if(arr_class != null && arr_v != null && arr_v.length > 0 && arr_class.length == (needSignalId ? 2 : 1)) {
                        Class paramType = arr_class[(needSignalId ? 1 : 0)];
                        for(int j = 0; j < arr_v.length; ++j) {
                            int regSignalId = arr_v[j];
                            if(regSignalId != -1) {
                                SignalReceiverHolder holder = new SignalReceiverHolder(receiver, method, paramType, needSignalId, annotation.valueToEnabledState());
                                List holders = (List)mSignalReceivers.get(Integer.valueOf(regSignalId));
                                if(holders == null) {
                                    holders = new ArrayList();
                                }
                                if(!holders.contains(holder)) {
                                    holders.add(holder);
                                }
                                mSignalReceivers.put(Integer.valueOf(regSignalId), holders);
                                List holdersTemp = (List)rsTemp.get(Integer.valueOf(regSignalId));
                                if(holdersTemp == null) {
                                    holdersTemp = new ArrayList();
                                }
                                if(!holdersTemp.contains(holder)) {
                                    holdersTemp.add(holder);
                                }
                                rsTemp.put(Integer.valueOf(regSignalId), holdersTemp);
                            }
                        }
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
        newOrRetryRegisterSignalCallback(rsTemp);
    }

    private void registerSignalCallback(ISignalCallback callback, int[] signalsId) {
        try {
            getService().registerSignalCallback(callback, signalsId);
            Log.w(TAG, "registerSignalCallback() newOrRetry " + Arrays.toString(signalsId) + ", " + callback);
        }
        catch(Throwable t) {
            Log.w(TAG, "registerSignalCallback() newOrRetry ", t);
            try {
                getService(true).registerSignalCallback(callback, signalsId);
            }
            catch(Throwable unused_ex) {
                Log.e(TAG, "registerSignalCallback() retry", t);
            }
        }
    }

    private void sendSignalCallback(int signalId, Number value) {
        Object retValue;
        int v2 = 0;
        List holders = (List)mSignalReceivers.get(Integer.valueOf(signalId));
        if(holders == null) {
            try {
                v2 = 0;
            }
            catch(Throwable t) {
                Log.e(TAG, "sendSignalCallback() for Number error", t);
            }
        }
        else {
            v2 = holders.size();
        }
        for(int i = 0; i < v2; ++i) {
            SignalReceiverHolder holder = (SignalReceiverHolder)holders.get(i);
            try {
                if(holder.valueToEnabledState) {
                    retValue = Boolean.valueOf(value.byteValue() == 1);
                }
                else if(holder.valueOfMethod != null) {
                    retValue = holder.valueOfMethod.invoke(null, value.intValue());
                }
                else if(holder.paramType.equals(Integer.TYPE) || holder.paramType.equals(Integer.class)) {
                    retValue = value.intValue();
                }
                else if(holder.paramType.equals(Byte.TYPE) || holder.paramType.equals(Byte.class)) {
                    retValue = value.byteValue();
                }
                else if(holder.paramType.equals(Short.TYPE) || holder.paramType.equals(Short.class)) {
                    retValue = value.shortValue();
                }
                else if(holder.paramType.equals(Long.TYPE) || holder.paramType.equals(Long.class)) {
                    retValue = value.longValue();
                }
                else if(holder.paramType.equals(Float.TYPE) || holder.paramType.equals(Float.class)) {
                    retValue = value.floatValue();
                }
                else if(holder.paramType.equals(Double.TYPE) || holder.paramType.equals(Double.class)) {
                    retValue = value.doubleValue();
                }
                else if(holder.paramType.equals(Boolean.TYPE) || holder.paramType.equals(Boolean.class)) {
                    retValue = Boolean.valueOf(value.byteValue() == 1);
                }
                else {
                    retValue = value;
                }
                if(holder.needSignalId) {
                    holder.method.invoke(holder.receiver.get(), signalId, retValue);
                }
                else {
                    holder.method.invoke(holder.receiver.get(), retValue);
                }
            }
            catch(Throwable t) {
                Log.e(TAG, "sendSignalCallback() for Number error", t);
            }
        }
    }

    private void sendSignalCallback(int signalId, byte[] values) {
        int v1 = 0;
        List holders = (List)mSignalReceivers.get(signalId);
        if(holders != null) {
            v1 = holders.size();
        }
        for(int i = 0; i < v1; ++i) {
            SignalReceiverHolder holder = (SignalReceiverHolder)holders.get(i);
            try {
                Object retValue = holder.valueOfMethod == null ? values : holder.valueOfMethod.invoke(null, values);
                if(holder.needSignalId) {
                    holder.method.invoke(holder.receiver.get(), signalId, retValue);
                }
                else {
                    holder.method.invoke(holder.receiver.get(), retValue);
                }
            }
            catch(Throwable t) {
                Log.e(TAG, "sendSignalCallback() for byte[] error", t);
            }
        }
    }

    public boolean setSignalValue(int signalId, byte value) {
        return setSignalValueInner(signalId, new CarData(value).getBytes());
    }

    public boolean setSignalValue(int signalId, double value) {
        return setSignalValueInner(signalId, new CarData(value).getBytes());
    }

    public boolean setSignalValue(int signalId, float value) {
        return setSignalValueInner(signalId, new CarData(value).getBytes());
    }

    public boolean setSignalValue(int signalId, int value) {
        return setSignalValueInner(signalId, new CarData(value).getBytes());
    }

    public boolean setSignalValue(int signalId, long value) {
        return setSignalValueInner(signalId, new CarData(value).getBytes());
    }

    public boolean setSignalValue(int signalId, short value) {
        return setSignalValueInner(signalId, new CarData(value).getBytes());
    }

    public boolean setSignalValue(int signalId, boolean value) {
        return value ? setSignalValue(signalId, 1) : setSignalValue(signalId, 0);
    }

    public boolean setSignalValue(int signalId, byte[] value) {
        return setSignalValueInner(signalId, new CarData(value, false).getBytes());
    }

    private boolean setSignalValueInner(int signalId, byte[] value) {
        try {
            return getService().setSignalValue(signalId, value);
        }
        catch(Throwable t) {
            Log.w(TAG, "setSignalValue()", t);
            try {
                return getService(true).setSignalValue(signalId, value);
            }
            catch(Throwable unused_ex) {
                Log.e(TAG, "setSignalValue() retry", t);
                return false;
            }
        }
    }

    public void unregisterReceiver(Object receiver) {
        Iterator iterator0 = mSignalReceivers.values().iterator();
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            List holders = (List)object1;
            if(holders != null) {
                ArrayList foundHolders = new ArrayList();
                for(Object object2: holders) {
                    SignalReceiverHolder holder = (SignalReceiverHolder)object2;
                    Object object3 = holder.receiver.get();
                    if(isObjectsEqual(object3, receiver) || object3 == null) {
                        foundHolders.add(holder);
                    }
                }
                holders.removeAll(foundHolders);
            }
            if(holders == null || holders.size() == 0) {
                iterator0.remove();
            }
        }
        newOrRetryRegisterSignalCallback(null);
    }

    private void unregisterSignalCallback(ISignalCallback callback) {
        try {
            getService().unregisterSignalCallback(callback);
        }
        catch(Throwable t) {
            Log.w(TAG, "unregisterSignalCallback()", t);
            try {
                getService(true).unregisterSignalCallback(callback);
            }
            catch(Throwable unused_ex) {
                Log.e(TAG, "unregisterSignalCallback() retry", t);
            }
        }
    }
}

