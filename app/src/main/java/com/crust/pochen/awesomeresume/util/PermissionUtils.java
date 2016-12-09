package com.crust.pochen.awesomeresume.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by pochen on 12/8/16.
 */


public class PermissionUtils {
    public static final int REQ_CODE_WRITE_EXTERNAL_STORAGE = 200;

    public static boolean checkPermission(@NonNull Context context, @NonNull String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                || ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(@NonNull Activity activity, @NonNull String[] permissions, int reqCode) {
        Log.d("pochen", "in requestPermission");
        ActivityCompat.requestPermissions(activity, permissions, reqCode);
    }

    public static void requestReadExternalStoragePermission(@NonNull Activity activity) {
        requestPermission(activity,
                new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                REQ_CODE_WRITE_EXTERNAL_STORAGE);
    }
}
