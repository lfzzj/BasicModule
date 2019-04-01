package com.lf.user;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.SeekBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lf.base.bases.BaseFragment;
import com.lf.base.utils.RouteUtils;

/**
 * Create by LF
 * Data: 2019/3/23
 * Describe:
 */

@Route(path = RouteUtils.User_Fragment_Main)
public class UserMainFragment extends BaseFragment {

    //一个带圆角背景和阴影的FrameLayout
    private CardView mCardview;

    @Override
    public int getLayoutResID() {
        return R.layout.user_fragment_main;
    }

    @Override
    public void initView() {
        mCardview = findView(R.id.cv_cardview);

    }

    @Override
    public void initListener() {
        mCardview.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mCardview.setRadius(10);//设置圆角半径
        mCardview.setCardElevation(20);//设置阴影半径
        mCardview.setContentPadding(10, 10, 10, 10);//设置cardView中子控件和父控件的距离
    }

    @Override
    public void onClick(View v, int id) {
        if (v == mCardview) {
            RouteUtils.enterUserInfoActivity();
        }
    }

}
