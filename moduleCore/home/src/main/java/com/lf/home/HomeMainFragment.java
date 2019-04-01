package com.lf.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lf.base.bases.BaseFragment;
import com.lf.base.utils.RouteUtils;
import com.lf.home.adapter.FmPagerAdapter;
import com.lf.home.ui.fragment.HomeHotFragment;
import com.lf.home.ui.fragment.HomeJokeFragment;
import com.lf.home.ui.fragment.HomeNewFragment;
import com.lf.home.ui.fragment.HomeSelectFragment;
import com.lf.home.ui.fragment.HomeVideoFragment;
import com.lf.home.ui.fragment.TabFragment;

import java.util.ArrayList;

/**
 * Create by LF
 * Data: 2019/3/23
 * Describe:
 */

@Route(path = RouteUtils.Home_Fragment_Main)
public class HomeMainFragment extends BaseFragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FmPagerAdapter pagerAdapter;

    private String[] titles = new String[]{"精选","最新","热门","视频","笑话","我的"};
    private ArrayList<Fragment> fragments = new ArrayList<>();


    @Override
    public int getLayoutResID() {
        return R.layout.home_fragment_main;
    }

    @Override
    public void initView() {
        tabLayout = findView(R.id.tablayout);
        viewPager = findView(R.id.viewpager);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        fragments.add(new HomeSelectFragment());
        fragments.add(new HomeNewFragment());
        fragments.add(new HomeHotFragment());
        fragments.add(new HomeVideoFragment());
        fragments.add(new HomeJokeFragment());

        fragments.add(new TabFragment());


        tabLayout.setupWithViewPager(viewPager,false);
        pagerAdapter = new FmPagerAdapter(fragments,getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }

    @Override
    public void onClick(View v, int id) {

    }
}
