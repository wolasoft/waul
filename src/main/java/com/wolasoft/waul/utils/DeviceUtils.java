package com.wolasoft.waul.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import com.jaredrummler.android.device.DeviceName;

public class DeviceUtils {

    public static boolean hasPhoneCapability(Context context) {
        PackageManager manager = context.getPackageManager();
        return (manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)
                || manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA));
    }

    public static String getDeviceName() {
        String name = DeviceName.getDeviceName();

        return name.toUpperCase();
    }
}
