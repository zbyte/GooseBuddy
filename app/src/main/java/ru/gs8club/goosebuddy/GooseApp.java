package ru.gs8club.goosebuddy;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GooseApp extends Application {
    private static final String SEPOLICY_NAME = "sepolicy-inject";
    private static final String TAG = "GooseApp";

    public static int exec(String command) {
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", command});

            StringBuilder stdout = new StringBuilder();
            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) stdout.append(line).append('\n');
            }
            StringBuilder stderr = new StringBuilder();
            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                String line;
                while ((line = r.readLine()) != null) stderr.append(line).append('\n');
            }

            p.waitFor();
            int exit = p.exitValue();

            if (stdout.length() > 0) Log.d(TAG, "stdout: " + stdout);
            if (stderr.length() > 0) Log.w(TAG, "stderr: " + stderr);

            return exit;
        } catch (Exception e) {
            Log.e(TAG, "Exception in exec: " + e);
            return -1;
        }
    }

    public static int execAsRoot(String... commands) {
        try {
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(p.getOutputStream());
            for (String cmd : commands) {
                os.writeBytes(cmd + "\n");
            }
            os.writeBytes("exit\n");
            os.flush();
            os.close();

            StringBuilder stdout = new StringBuilder();
            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) stdout.append(line).append('\n');
            }
            StringBuilder stderr = new StringBuilder();
            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                String line;
                while ((line = r.readLine()) != null) stderr.append(line).append('\n');
            }

            p.waitFor();
            int exit = p.exitValue();

            if (stdout.length() > 0) Log.d(TAG, "stdout: " + stdout);
            if (stderr.length() > 0) Log.w(TAG, "stderr: " + stderr);

            return exit;
        } catch (Exception e) {
            Log.e(TAG, "Exception in execAsRoot: " + e);
            return -1;
        }
    }

    private void extractBinary(Context context) {
        File bin = new File(context.getFilesDir().getAbsolutePath(), SEPOLICY_NAME);
        if (bin.exists()) {
            Log.d(TAG, "Binary '" + bin.getAbsolutePath() + "' already exist");
        } else {
            Log.d(TAG, "Try extract binary to " + bin.getAbsolutePath());
            try (InputStream is = context.getAssets().open(SEPOLICY_NAME);
                 FileOutputStream fos = new FileOutputStream(bin)) {
                byte[] buf = new byte[4096];
                int len;
                while ((len = is.read(buf)) > 0) {
                    fos.write(buf, 0, len);
                }
            } catch (IOException e) {
                Log.e(TAG, "Exception in extractBinary: " + e);
                return;
            }
        }
        exec("chmod 755 " + bin.getAbsolutePath());
    }

    private void injectSELinuxRules(Context context) {
        Log.d(TAG, "Try inject SELinux rules");
        String inject = context.getFilesDir().getAbsolutePath() + "/" + SEPOLICY_NAME;

        boolean isRoot = android.os.Process.myUid() == 0;
        Log.d(TAG, "Running as root: " + isRoot);

        String[] rules = {
                inject + " -s init -t hal_drm_hwservice -c hwservice_manager -p add -l",
                inject + " -s init -t hidl_base_hwservice -c hwservice_manager -p add -l",
        };

        for (String rule : rules) {
            int result = isRoot ? exec(rule) : execAsRoot(rule);
            Log.d(TAG, "SELinux rule inject result: " + result + ". cmd: " + rule);
            if (result != 0) {
                Log.e(TAG, "SELinux rule injection failed, stopping");
                break;
            }
        }
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Application onCreate");

//        extractBinary(this);
//        injectSELinuxRules(this);

        super.onCreate();
        Intent serviceIntent = new Intent(this, CarService.class);
        startForegroundService(serviceIntent);
    }
}
