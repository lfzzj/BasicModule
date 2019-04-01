package com.lf.user;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lf.base.bases.BaseActivity;
import com.lf.base.utils.RouteUtils;

/**
 * Create by LF
 * Data: 2019/3/26
 * Describe:用户信息
 */

@Route(path = RouteUtils.User_UserInfo_Activity)
public class UserInfoActivity extends BaseActivity {
    @Override
    public int getLayoutResID() {
        return R.layout.user_activity_user_info;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }
}
