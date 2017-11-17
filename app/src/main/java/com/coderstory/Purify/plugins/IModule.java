package com.coderstory.Purify.plugins;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public interface IModule {
    void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam);

    void initZygote(IXposedHookZygoteInit.StartupParam startupParam);
}
