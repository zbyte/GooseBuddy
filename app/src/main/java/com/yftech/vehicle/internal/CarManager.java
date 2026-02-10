package com.yftech.vehicle.internal;

import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
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

class CarManager {
    class SignalCallback extends Stub {
        private SignalCallback() {
        }

        SignalCallback(com.yftech.vehicle.internal.CarManager ptr) {
        }

        @Override  // com.yftech.vehicle.internal.ISignalCallback
        public void onValueChanged(int v, byte[] arr_b) throws RemoteException {
            StringBuffer stringBuffer0 = new StringBuffer();
            for(int v1 = 0; v1 < arr_b.length; ++v1) {
                stringBuffer0.append(Integer.toHexString(arr_b[v1]));
                stringBuffer0.append(", ");
            }
            CarData carData0 = new CarData(arr_b);
            if(carData0.isDataValue()) {
                byte[] arr_b1 = carData0.dataValue();
                CarManager.this.sendSignalCallback(v, arr_b1);
                return;
            }
            Number number0 = carData0.numberValue();
            CarManager.this.sendSignalCallback(v, number0);
        }
    }

    class SignalReceiverHolder {
        Method method;
        boolean needSignalId;
        Class paramType;
        Reference receiver;
        Method valueOfMethod;
        boolean valueToEnabledState;

        SignalReceiverHolder(Object object0, Method method0, Class class0, boolean z, boolean z1) {
            this.receiver = new WeakReference(object0);
            this.method = method0;
            this.paramType = class0;
            this.needSignalId = z;
            this.valueToEnabledState = z1;
            if(class0.isEnum() || class0 == CarKeyEvent.class || class0 == KeyTestEvent.class || class0 == ErrorCodeInfo.class || class0 == DeviceNode.class || class0 == SetItemUnitInfo.class || class0 == DisplayDtc.class || class0 == PersonalMemoryInfo.class) {
                try {
                    this.valueOfMethod = class0.getMethod("valueOf", Integer.TYPE);
                }
                catch(Throwable unused_ex) {
                    try {
                        this.valueOfMethod = class0.getMethod("valueOf", byte[].class);
                    }
                    catch(Throwable throwable0) {
                        Log.e("CarManager", "SignalReceiverHolder<init> valueOf byte[] error", throwable0);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 == null) {
                return false;
            }
            if(this.getClass() != object0.getClass()) {
                return false;
            }
            if(this.receiver.get() == null) {
                if(((SignalReceiverHolder)object0).receiver.get() != null) {
                    return false;
                }
            }
            else if(!this.receiver.get().equals(((SignalReceiverHolder)object0).receiver.get())) {
                return false;
            }
            return this.method == null ? ((SignalReceiverHolder)object0).method == null : this.method.equals(((SignalReceiverHolder)object0).method);
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.receiver == null ? 0 : this.receiver.hashCode();
            if(this.method != null) {
                v = this.method.hashCode();
            }
            return (v1 + 0x1F) * 0x1F + v;
        }

        @Override
        public String toString() {
            return "SignalReceiverHolder{receiver=" + this.receiver.getClass().getSimpleName() + ", method=" + this.method.getName() + '}';
        }
    }

    private static final String SERVICE_NAME = "yfcarservice";
    private static final String TAG = "CarManager";
    private SignalCallback mCallback;
    private IBinder.DeathRecipient mDeathRecipient;
    private byte[] mL;
    private static ICarService mService;
    private Map mSignalReceivers;
    private static CarManager sMe;

    private CarManager() {
        this.mL = new byte[0];
        this.mDeathRecipient = new IBinder.DeathRecipient() {
            @Override  // android.os.IBinder$DeathRecipient
            public void binderDied() {
                int v = 0;
                if(CarManager.mService != null) {
                    CarManager.mService.asBinder().unlinkToDeath(this, 0);
                    CarManager.mService = null;
                }
                while(v <= 2 && CarManager.mService == null) {
                    try {
                        ++v;
                        Thread.sleep(1000L);
                        CarManager.this.getService();
                        StringBuilder stringBuilder0 = new StringBuilder();
                        stringBuilder0.append("service dead ,mDeathRecipient-> try conn 1000ms-> count =");
                        stringBuilder0.append(v);
                        stringBuilder0.append(" mService=");
                        Integer integer0 = CarManager.mService == null ? "null" : CarManager.mService.hashCode();
                        stringBuilder0.append(integer0);
                        Log.w("CarManager", stringBuilder0.toString());
                        if(CarManager.mService == null) {
                            continue;
                        }
                        CarManager.this.newOrRetryRegisterSignalCallback(null);
                    }
                    catch(InterruptedException unused_ex) {
                        Log.w("CarManager", "service dead , try conn sleep 1000ms error !");
                        break;
                    }
                }
            }
        };
        this.mSignalReceivers = new HashMap();
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
        return this.getService(false);
    }

    private ICarService getService(boolean z) {
        synchronized(this.mL) {
            if(CarManager.mService == null || z) {
                CarManager.mService = null;
                IBinder iBinder0 = ServiceManager.getService("yfcarservice");
                if(iBinder0 != null) {
                    try {
                        iBinder0.linkToDeath(this.mDeathRecipient, 0);
                        CarManager.mService = com.yftech.vehicle.internal.ICarService.Stub.asInterface(iBinder0);
                    }
                    catch(RemoteException remoteException0) {
                        Log.e("CarManager", "getService->linkToDeath error, e->" + remoteException0.getMessage());
                    }
                }
            }
            return CarManager.mService;
        }
    }

    public byte[] getSignalDataValue(int v) {
        return new CarData(this.getSignalValueInner(v)).dataValue();
    }

    public Number getSignalValue(int v) {
        return new CarData(this.getSignalValueInner(v)).numberValue();
    }

    private byte[] getSignalValueInner(int v) {
        try {
            return this.getService().getSignalValue(v);
        }
        catch(Throwable throwable0) {
            Log.w("CarManager", "getSignalValue()", throwable0);
            try {
                return this.getService(true).getSignalValue(v);
            }
            catch(Throwable unused_ex) {
                Log.e("CarManager", "getSignalValue() retry", throwable0);
                return null;
            }
        }
    }

    public Number[] getSignalsValue(int[] arr_v) {
        byte[] arr_b = this.getSignalsValueInner(arr_v);
        if(arr_b != null && arr_b.length == arr_v.length) {
            Number[] arr_number = new Number[arr_b.length];
            CarData carData0 = new CarData(arr_b);
            for(int v = 0; v < arr_number.length; ++v) {
                arr_number[v] = carData0.numberValue();
                carData0.next();
            }
            return arr_number;
        }
        return null;
    }

    private byte[] getSignalsValueInner(int[] arr_v) {
        try {
            return this.getService().getSignalsValue(arr_v);
        }
        catch(Throwable throwable0) {
            Log.w("CarManager", "getSignalsValue()", throwable0);
            try {
                return this.getService(true).getSignalsValue(arr_v);
            }
            catch(Throwable unused_ex) {
                Log.e("CarManager", "getSignalsValue() retry", throwable0);
                return null;
            }
        }
    }

    private boolean isObjectsEqual(Object object0, Object object1) {
        return object0 != null && object0.equals(object1);
    }

    public static boolean isServiceConnected() {
        synchronized(CarManager.class) {
        }
        return CarManager.mService != null;
    }

    private boolean isSystemCalss(String s) {
        return s.startsWith("java.") || s.startsWith("javax.") || s.startsWith("android.");
    }

    private void newOrRetryRegisterSignalCallback(Map map0) {
        int v = map0 == null ? this.mSignalReceivers.size() : map0.size();
        if(v > 0) {
            int v1 = 0;
            int[] arr_v = new int[v];
            if(map0 == null) {
                map0 = this.mSignalReceivers;
            }
            for(Object object0: map0.keySet()) {
                arr_v[v1] = (int)(((Integer)object0));
                ++v1;
            }
            if(this.mCallback == null) {
                this.mCallback = new SignalCallback(this, null);
            }
            this.registerSignalCallback(this.mCallback, arr_v);
            return;
        }
        this.unregisterSignalCallback(this.mCallback);
    }

    public void registerReceiver(Object object0) {
        int[] arr_v2;
        int v6;
        Class class0 = object0.getClass();
        HashMap hashMap0 = new HashMap();
        for(Class class1 = class0; class1 != null && !this.isSystemCalss(class1.getName()); class1 = class1.getSuperclass()) {
            Method[] arr_method = class1.getDeclaredMethods();
            for(int v = 0; v < arr_method.length; ++v) {
                Method method0 = arr_method[v];
                SignalReceiver signalReceiver0 = (SignalReceiver)method0.getAnnotation(SignalReceiver.class);
                if(signalReceiver0 != null) {
                    Class[] arr_class = method0.getParameterTypes();
                    int v1 = signalReceiver0.signalId();
                    int[] arr_v = signalReceiver0.signalsIdArray();
                    int v2 = 1;
                    int v3 = arr_v == null || arr_v.length <= 0 || arr_v[0] < 0 ? 0 : 1;
                    if(v3 == 0 && v1 >= 0) {
                        arr_v = new int[]{v1};
                    }
                    int[] arr_v1 = arr_v;
                    if(arr_class != null && arr_v1 != null && arr_v1.length > 0) {
                        if(v3 != 0) {
                            v2 = 2;
                        }
                        if(arr_class.length == v2) {
                            Class class2 = arr_class[v3];
                            int v4 = 0;
                            while(v4 < arr_v1.length) {
                                int v5 = arr_v1[v4];
                                if(v5 == -1) {
                                    v6 = v4;
                                    arr_v2 = arr_v1;
                                }
                                else {
                                    v6 = v4;
                                    arr_v2 = arr_v1;
                                    SignalReceiverHolder carManager$SignalReceiverHolder0 = new SignalReceiverHolder(this, object0, method0, class2, ((boolean)v3), signalReceiver0.valueToEnabledState());
                                    List list0 = (List)this.mSignalReceivers.get(Integer.valueOf(v5));
                                    if(list0 == null) {
                                        list0 = new ArrayList();
                                    }
                                    if(!list0.contains(carManager$SignalReceiverHolder0)) {
                                        list0.add(carManager$SignalReceiverHolder0);
                                    }
                                    this.mSignalReceivers.put(Integer.valueOf(v5), list0);
                                    List list1 = (List)hashMap0.get(Integer.valueOf(v5));
                                    if(list1 == null) {
                                        list1 = new ArrayList();
                                    }
                                    if(!list1.contains(carManager$SignalReceiverHolder0)) {
                                        list1.add(carManager$SignalReceiverHolder0);
                                    }
                                    hashMap0.put(Integer.valueOf(v5), list1);
                                }
                                v4 = v6 + 1;
                                arr_v1 = arr_v2;
                            }
                        }
                    }
                }
            }
        }
        this.newOrRetryRegisterSignalCallback(hashMap0);
    }

    private void registerSignalCallback(ISignalCallback iSignalCallback0, int[] arr_v) {
        try {
            this.getService().registerSignalCallback(iSignalCallback0, arr_v);
            Log.w("CarManager", "registerSignalCallback() newOrRetry " + Arrays.toString(arr_v) + ", " + iSignalCallback0);
        }
        catch(Throwable throwable0) {
            Log.w("CarManager", "registerSignalCallback() newOrRetry ", throwable0);
            try {
                this.getService(true).registerSignalCallback(iSignalCallback0, arr_v);
            }
            catch(Throwable unused_ex) {
                Log.e("CarManager", "registerSignalCallback() retry", throwable0);
            }
        }
    }

    private void sendSignalCallback(int v, Number number0) {
        Object object0;
        List list0 = (List)this.mSignalReceivers.get(Integer.valueOf(v));
        int v1 = list0 == null ? 0 : list0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            SignalReceiverHolder carManager$SignalReceiverHolder0 = (SignalReceiverHolder)list0.get(v2);
            try {
                if(carManager$SignalReceiverHolder0.valueToEnabledState) {
                    object0 = Boolean.valueOf(number0.byteValue() == 1);
                }
                else if(carManager$SignalReceiverHolder0.valueOfMethod != null) {
                    object0 = carManager$SignalReceiverHolder0.valueOfMethod.invoke(null, number0.intValue());
                }
                else if(carManager$SignalReceiverHolder0.paramType.equals(Integer.TYPE) || carManager$SignalReceiverHolder0.paramType.equals(Integer.class)) {
                    object0 = number0.intValue();
                }
                else if(carManager$SignalReceiverHolder0.paramType.equals(Byte.TYPE) || carManager$SignalReceiverHolder0.paramType.equals(Byte.class)) {
                    object0 = number0.byteValue();
                }
                else if(carManager$SignalReceiverHolder0.paramType.equals(Short.TYPE) || carManager$SignalReceiverHolder0.paramType.equals(Short.class)) {
                    object0 = number0.shortValue();
                }
                else if(carManager$SignalReceiverHolder0.paramType.equals(Long.TYPE) || carManager$SignalReceiverHolder0.paramType.equals(Long.class)) {
                    object0 = number0.longValue();
                }
                else if(carManager$SignalReceiverHolder0.paramType.equals(Float.TYPE) || carManager$SignalReceiverHolder0.paramType.equals(Float.class)) {
                    object0 = number0.floatValue();
                }
                else if(carManager$SignalReceiverHolder0.paramType.equals(Double.TYPE) || carManager$SignalReceiverHolder0.paramType.equals(Double.class)) {
                    object0 = number0.doubleValue();
                }
                else if(!carManager$SignalReceiverHolder0.paramType.equals(Boolean.TYPE) && !carManager$SignalReceiverHolder0.paramType.equals(Boolean.class)) {
                    object0 = number0;
                }
                else {
                    object0 = Boolean.valueOf(number0.byteValue() == 1);
                }
                if(carManager$SignalReceiverHolder0.needSignalId) {
                    carManager$SignalReceiverHolder0.method.invoke(carManager$SignalReceiverHolder0.receiver.get(), v, object0);
                }
                else {
                    carManager$SignalReceiverHolder0.method.invoke(carManager$SignalReceiverHolder0.receiver.get(), object0);
                }
            }
            catch(Throwable throwable0) {
                Log.e("CarManager", "sendSignalCallback() for Number error", throwable0);
            }
        }
    }

    private void sendSignalCallback(int v, byte[] arr_b) {
        List list0 = (List)this.mSignalReceivers.get(Integer.valueOf(v));
        int v1 = list0 == null ? 0 : list0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            SignalReceiverHolder carManager$SignalReceiverHolder0 = (SignalReceiverHolder)list0.get(v2);
            try {
                Object object0 = carManager$SignalReceiverHolder0.valueOfMethod == null ? arr_b : carManager$SignalReceiverHolder0.valueOfMethod.invoke(null, arr_b);
                if(carManager$SignalReceiverHolder0.needSignalId) {
                    carManager$SignalReceiverHolder0.method.invoke(carManager$SignalReceiverHolder0.receiver.get(), v, object0);
                }
                else {
                    carManager$SignalReceiverHolder0.method.invoke(carManager$SignalReceiverHolder0.receiver.get(), object0);
                }
            }
            catch(Throwable throwable0) {
                Log.e("CarManager", "sendSignalCallback() for byte[] error", throwable0);
            }
        }
    }

    public boolean setSignalValue(int v, byte b) {
        return this.setSignalValueInner(v, new CarData(b).getBytes());
    }

    public boolean setSignalValue(int v, double f) {
        return this.setSignalValueInner(v, new CarData(f).getBytes());
    }

    public boolean setSignalValue(int v, float f) {
        return this.setSignalValueInner(v, new CarData(f).getBytes());
    }

    public boolean setSignalValue(int v, int v1) {
        return this.setSignalValueInner(v, new CarData(v1).getBytes());
    }

    public boolean setSignalValue(int v, long v1) {
        return this.setSignalValueInner(v, new CarData(v1).getBytes());
    }

    public boolean setSignalValue(int v, short v1) {
        return this.setSignalValueInner(v, new CarData(v1).getBytes());
    }

    public boolean setSignalValue(int v, boolean z) {
        return this.setSignalValue(v, ((byte)z));
    }

    public boolean setSignalValue(int v, byte[] arr_b) {
        return this.setSignalValueInner(v, new CarData(arr_b, false).getBytes());
    }

    private boolean setSignalValueInner(int v, byte[] arr_b) {
        try {
            return this.getService().setSignalValue(v, arr_b);
        }
        catch(Throwable throwable0) {
            Log.w("CarManager", "setSignalValue()", throwable0);
            try {
                return this.getService(true).setSignalValue(v, arr_b);
            }
            catch(Throwable unused_ex) {
                Log.e("CarManager", "setSignalValue() retry", throwable0);
                return false;
            }
        }
    }

    public void unregisterReceiver(Object object0) {
        Iterator iterator0 = this.mSignalReceivers.values().iterator();
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            List list0 = (List)object1;
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object2: list0) {
                    SignalReceiverHolder carManager$SignalReceiverHolder0 = (SignalReceiverHolder)object2;
                    Object object3 = carManager$SignalReceiverHolder0.receiver.get();
                    if(this.isObjectsEqual(object3, object0) || object3 == null) {
                        arrayList0.add(carManager$SignalReceiverHolder0);
                    }
                }
                list0.removeAll(arrayList0);
            }
            if(list0 == null || list0.size() == 0) {
                iterator0.remove();
            }
        }
        this.newOrRetryRegisterSignalCallback(null);
    }

    private void unregisterSignalCallback(ISignalCallback iSignalCallback0) {
        try {
            this.getService().unregisterSignalCallback(iSignalCallback0);
        }
        catch(Throwable throwable0) {
            Log.w("CarManager", "unregisterSignalCallback()", throwable0);
            try {
                this.getService(true).unregisterSignalCallback(iSignalCallback0);
            }
            catch(Throwable unused_ex) {
                Log.e("CarManager", "unregisterSignalCallback() retry", throwable0);
            }
        }
    }
}

