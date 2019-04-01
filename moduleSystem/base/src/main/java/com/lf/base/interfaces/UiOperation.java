package com.lf.base.interfaces;

import android.view.View;

/**
 * Create by LF
 * Data: 2019/3/23
 * Describe:Ui操作接口
 */
public interface UiOperation  extends View.OnClickListener {
    /**
     * 返回一个用于显示界面的布局id
     */
    int getLayoutResID();

    /** 初始化View，findViewById的代码写到这个方法里面 */
        void initView();

    /**
     * 初始化监听器
     */
    void initListener();

    /**
     * 初始化数据，并显示到界面上
     */
    void initData();

    /**
     * 单击事件在这个方法中处理
     *
     * @param v  单击的控件
     * @param id 单击控件的id
     */
    void onClick(View v, int id);
}
