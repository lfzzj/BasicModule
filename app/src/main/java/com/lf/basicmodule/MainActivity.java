package com.lf.basicmodule;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lf.base.bases.BaseActivity;
import com.lf.base.utils.RouteUtils;

import java.io.IOException;

import butterknife.BindView;

import static com.lf.base.utils.RouteUtils.TAG_FRAGMENT_FIND;
import static com.lf.base.utils.RouteUtils.TAG_FRAGMENT_FRD;
import static com.lf.base.utils.RouteUtils.TAG_FRAGMENT_HOME;
import static com.lf.base.utils.RouteUtils.TAG_FRAGMENT_USER;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_main)
    FrameLayout flMain;

    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.rb_home)
    RadioButton tabHome;

    private FragmentManager supportFragmentManager;


    private Fragment curFragment;//当前展示的fragment


    @Override
    public int getLayoutResID() {
        return R.layout.app_activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        rgTab.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    @Override
    public void initData() {
        supportFragmentManager = getSupportFragmentManager();
        switchTab(R.id.rb_home);

    }

    @Override
    public void onClick(View v, int id) {


    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switchTab(checkedId);
        }
    };


    /**
     * 切换Tab
     *
     * @param id
     */
    private void switchTab(int id) {

        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        hideAllFragment(ft);
        String tag = TAG_FRAGMENT_HOME;
        switch (id) {
            case R.id.rb_home:
                tag = TAG_FRAGMENT_HOME;
                break;
            case R.id.rb_frd:
                tag = TAG_FRAGMENT_FRD;
                break;
            case R.id.rb_find:
                tag = TAG_FRAGMENT_FIND;
                break;
            case R.id.rb_user:
                tag = TAG_FRAGMENT_USER;
                break;
        }

        addFragment(ft, tag);

        if (curFragment != null) {
            ft.show(curFragment).commit();
        }

    }


    /**
     * 添加fragment
     *
     * @param ft
     * @param TAG
     */
    private void addFragment(FragmentTransaction ft, String TAG) {
        Fragment mFragment = supportFragmentManager.findFragmentByTag(TAG);
        if (mFragment == null) {
            mFragment = RouteUtils.getCurFragment(TAG);
            if (mFragment != null) {
                ft.add(R.id.fl_main, mFragment, TAG);
            }
        }
        curFragment = mFragment;
    }

    /**
     * 隐藏所有
     *
     * @param ft
     */
    private void hideAllFragment(FragmentTransaction ft) {
        hintFragment(ft, TAG_FRAGMENT_HOME);
        hintFragment(ft, TAG_FRAGMENT_FRD);
        hintFragment(ft, TAG_FRAGMENT_FIND);
        hintFragment(ft, TAG_FRAGMENT_USER);

    }

    private void hintFragment(FragmentTransaction ft, String tag) {
        Fragment fragment;
        fragment = supportFragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            ft.hide(fragment);
        }
    }


}
