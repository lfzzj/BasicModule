package com.lf.basicmodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Create by LF
 * Data: 2019/3/22
 * Describe:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouterInit();
    }

    private void ARouterInit(){
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
