package com.lf.base.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Create by LF
 * Data: 2019/3/23
 * Describe:路由的工具类
 */
public class RouteUtils {

    public static final String Home_Fragment_Main = "/home/main";
    public static final String Find_Fragment_Main = "/find/main";
    public static final String User_Fragment_Main = "/user/main";
    public static final String Frd_Fragment_Main = "/frd/main";

    public static final String User_UserInfo_Activity = "/user/userinfo";//用户信息

    public static final String TAG_FRAGMENT_HOME = "home";
    public static final String TAG_FRAGMENT_FRD = "frd";
    public static final String TAG_FRAGMENT_FIND = "find";
    public static final String TAG_FRAGMENT_USER = "user";

    public static final String ROUTE_BUNDLE = "bundle";

    /**
     * 获取当前使用的fragment
     *
     * @param tag
     * @return
     */
    public static Fragment getCurFragment(String tag) {
        Fragment fragment = (Fragment) ARouter.getInstance().build(getFragmentMain(tag)).navigation();
        return fragment;
    }

    /**
     * 根据tag 获取首页不同的fragment
     *
     * @param tag
     * @return
     */
    private static String getFragmentMain(String tag) {
        if (tag.equals(TAG_FRAGMENT_HOME)) {
            return Home_Fragment_Main;
        } else if (tag.equals(TAG_FRAGMENT_FRD)) {
            return Frd_Fragment_Main;
        } else if (tag.equals(TAG_FRAGMENT_FIND)) {
            return Find_Fragment_Main;
        } else {
            return User_Fragment_Main;
        }
    }

    /**
     * 进入用户信息界面
     */
    public static void enterUserInfoActivity() {
        openActivity(User_UserInfo_Activity);
    }


    /**
     * 根据路径打开activity
     *
     * @param path
     */
    private static void openActivity(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 携带参数的参数activity
     *
     * @param path
     * @param bundle
     */
    public static void openActivity(String path, Bundle bundle) {
        ARouter.getInstance().build(path).withBundle(ROUTE_BUNDLE,bundle).navigation();
    }
}
