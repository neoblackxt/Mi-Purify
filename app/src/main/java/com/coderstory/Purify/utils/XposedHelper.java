package com.coderstory.Purify.utils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

import static com.coderstory.Purify.config.Misc.ApplicationName;
import static com.coderstory.Purify.config.Misc.SharedPreferencesName;

public class XposedHelper {
    protected XSharedPreferences prefs = new XSharedPreferences(ApplicationName, SharedPreferencesName);

    {
        prefs.makeWorldReadable();
        prefs.reload();
    }


    public static void findAndHookMethod(String p1, ClassLoader lpparam, String p2, Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookMethod(p1, lpparam, p2, parameterTypesAndCallback);

        } catch (Throwable localString3) {
            XposedBridge.log(localString3);
        }
    }

    public static void hookAllConstructors(String p1, XC_MethodHook parameterTypesAndCallback) {
        try {
            Class packageParser = XposedHelpers.findClass(p1, null);
            XposedBridge.hookAllConstructors(packageParser, parameterTypesAndCallback);

        } catch (Throwable localString3) {
            XposedBridge.log(localString3);
        }
    }

    protected static void findAndHookMethod(String p1, String p2, Object[] p3) {
        try {
            XposedHelpers.findAndHookMethod(Class.forName(p1), p2, p3);
        } catch (Throwable localString3) {
            XposedBridge.log(localString3);
        }
    }

    public static void hookAllMethods(String p1, ClassLoader lpparam, String methodName, XC_MethodHook parameterTypesAndCallback) {
        try {
            Class packageParser = XposedHelpers.findClass(p1, lpparam);
            XposedBridge.hookAllMethods(packageParser, methodName, parameterTypesAndCallback);

        } catch (Throwable localString3) {
            XposedBridge.log(localString3);
        }
    }


    protected static Object getDrmResultSUCCESS() {
        try {
            Class<Enum> drmSuccess = (Class<Enum>) Class.forName("miui.drm.DrmManager$DrmResult");
            if (drmSuccess != null) {
                return Enum.valueOf(drmSuccess, "DRM_SUCCESS");
            }
        } catch (Throwable localString4) {
            XposedBridge.log(localString4);

        }
        return null;
    }


}
