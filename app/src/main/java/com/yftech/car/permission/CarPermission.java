package com.yftech.car.permission;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import com.yftech.car.utils.SystemPropertiesHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class CarPermission {
    static class PermissionStruct {
        final String mPackageName;
        final Set mPermissionSet;

        PermissionStruct(String packageName, List list0) {
            this.mPackageName = packageName;
            if(list0 == null || list0.isEmpty()) {
                this.mPermissionSet = new HashSet();
                return;
            }
            this.mPermissionSet = new HashSet(list0);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{").append("packageName=").append(this.mPackageName);
            stringBuilder.append(", permissions=[");
            boolean first = true;
            for(Object object0: this.mPermissionSet) {
                if(first) {
                    first = false;
                    stringBuilder.append(",");
                }
                stringBuilder.append(((String)object0));
            }
            stringBuilder.append("]");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    private static final String PERMISSIONS_WHITE_LIST_FILE = "/system/etc/yftech_permissions_white_list.xml";
    private static String TAG;
    private static boolean mHasLoadedWhiteList = false;
    private static final Map mPermissionWhiteMap = new HashMap();
    private static final int mSelfPid = Process.myPid();

    public static boolean checkPermission(Context context, int pid, int uid, String permission) {
        ArrayList permissionList = new ArrayList();
        permissionList.add(permission);
        return CarPermission.checkPermission(context, pid, uid, permissionList);
    }

    public static boolean checkPermission(Context context, int pid, int uid, List list0) {
        if(SystemPropertiesHelper.getBoolean("yf.permission.enable", false) && pid != CarPermission.mSelfPid) {
            if(context == null) {
                Log.e(CarPermission.TAG, "checkPermission, denied for context null");
                return false;
            }
            if(list0 != null && !list0.isEmpty() && !CarPermission.checkPermissionInManifest(context, pid, uid, list0) && !CarPermission.checkPermissionInWhiteList(context, uid, list0)) {
                Log.e(CarPermission.TAG, "checkPermission, denied for permission not granted of " + Arrays.toString(list0.toArray()));
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermission(Context context, String permission) {
        ArrayList permissionList = new ArrayList();
        permissionList.add(permission);
        return CarPermission.checkPermission(context, permissionList);
    }

    public static boolean checkPermission(Context context, List list0) {
        return CarPermission.checkPermission(context, Binder.getCallingPid(), Binder.getCallingUid(), list0);
    }

    private static boolean checkPermissionInManifest(Context context, int pid, int uid, List list0) {
        if(context == null || list0 == null || list0.isEmpty()) {
            return false;
        }
        for(Object object0: list0) {
            String permission = (String)object0;
            if(!TextUtils.isEmpty(permission) && context.checkPermission(permission, pid, uid) != PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPermissionInWhiteList(Context context, int uid, List list0) {
        if(context == null || list0 == null || list0.isEmpty()) {
            return false;
        }
        if(!CarPermission.mHasLoadedWhiteList) {
            synchronized(CarPermission.mPermissionWhiteMap) {
                long timeout = 3000L;
                while(timeout > 0L) {
                    long v3 = SystemClock.uptimeMillis();
                    try {
                        CarPermission.mPermissionWhiteMap.wait(timeout, 0);
                    }
                    catch(InterruptedException e) {
                        e.printStackTrace();
                        timeout -= SystemClock.uptimeMillis() - v3;
                    }
                }
            }
            if(!CarPermission.mHasLoadedWhiteList) {
                Log.e(CarPermission.TAG, "checkPermissionInWhiteList, white list not load");
                return false;
            }
        }
        String[] arr_s = context.getPackageManager().getPackagesForUid(uid);
        if(arr_s == null) {
            return false;
        }
        int v4 = 0;
        while(v4 < arr_s.length) {
            PermissionStruct permissionStruct = (PermissionStruct)CarPermission.mPermissionWhiteMap.get(arr_s[v4]);
            if(permissionStruct != null) {
                boolean isAllGrant = true;
                for(Object object0: list0) {
                    String requestPermission = (String)object0;
                    boolean isGrant = false;
                    for(Object object1: permissionStruct.mPermissionSet) {
                        if(TextUtils.isEmpty(requestPermission) || requestPermission.equals(((String)object1))) {
                            isGrant = true;
                            break;
                        }
                    }
                    if(isGrant) {
                        continue;
                    }
                    else {
                        isAllGrant = false;
                        break;
                    }
                }
                if(isAllGrant) {
                    return true;
                }
            }
            ++v4;
        }
        return false;
    }

    public static String dump() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("white list of yftech permissions: {\n");
        for(Object object0: CarPermission.mPermissionWhiteMap.values()) {
            stringBuilder.append(((PermissionStruct)object0).toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("}\n");
        return "white list of yftech permissions: {\n}\n";
    }

    public static void initAsync(String tag, Runnable callback) {
        if(tag == null) {
            throw new NullPointerException("tag can not be null");
        }
        CarPermission.TAG = tag;
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(CarPermission.mPermissionWhiteMap) {
                    CarPermission.loadPermissionWhiteList();
                    CarPermission.mHasLoadedWhiteList = true;
                    CarPermission.mPermissionWhiteMap.notifyAll();
                }
                if(callback != null) {
                    callback.run();
                }
            }
        }, "yfpermission.thread").start();
    }

    public static void initSync(String tag) {
        if(tag == null) {
            throw new NullPointerException("tag can not be null");
        }
        CarPermission.TAG = tag;
        synchronized(CarPermission.mPermissionWhiteMap) {
            CarPermission.loadPermissionWhiteList();
            CarPermission.mHasLoadedWhiteList = true;
            CarPermission.mPermissionWhiteMap.notifyAll();
        }
    }

    private static void loadPermissionWhiteList() {
        FileInputStream inputStream = null;
        File whiteListFile = new File("/system/etc/yftech_permissions_white_list.xml");
        if(!whiteListFile.exists()) {
            Log.i(CarPermission.TAG, "loadPermissionWhiteList, white list file not exist");
            return;
        }
        try {
            inputStream = new FileInputStream(whiteListFile);
            XmlPullParser xmlPullParser0 = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParser0.setInput(inputStream, "UTF-8");
            int eventType = xmlPullParser0.getEventType();
            while(eventType != 1) {
                String s = xmlPullParser0.getName();
                if(eventType != 2) {
                    eventType = xmlPullParser0.next();
                    continue;
                }
                if(!"yf_permissions".equals(s)) {
                    if("permission".equals(s)) {
                        String s1 = xmlPullParser0.getAttributeValue(null, "pkg_name");
                        if(!TextUtils.isEmpty(s1)) {
                            String s2 = xmlPullParser0.getAttributeValue(null, "perm_list");
                            ArrayList perList = new ArrayList();
                            if(!TextUtils.isEmpty(s2)) {
                                String[] arr_s = s2.split(",");
                                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                                    perList.add(arr_s[v1].trim());
                                }
                                PermissionStruct permissionStruct = (PermissionStruct)CarPermission.mPermissionWhiteMap.get(s1);
                                if(permissionStruct == null) {
                                    permissionStruct = new PermissionStruct(s1, perList);
                                }
                                else {
                                    permissionStruct.mPermissionSet.addAll(perList);
                                }
                                CarPermission.mPermissionWhiteMap.put(s1, permissionStruct);
                            }
                        }
                    }
                    eventType = xmlPullParser0.next();
                    continue;
                }
                if("true".equals(xmlPullParser0.getAttributeValue(null, "enable"))) {
                    eventType = xmlPullParser0.next();
                    continue;
                }
                else {
                    Log.i(CarPermission.TAG, "loadPermissionWhiteList, white list is disable");
                    break;
                }
            }
        }
        catch(XmlPullParserException xmlPullParserException0) {
            xmlPullParserException0.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        if(inputStream != null) {
            try {
                inputStream.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}

