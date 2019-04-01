package com.lf.base.bases;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lf.base.R;
import com.lf.base.interfaces.UiOperation;


/**
 * Create by LF
 * Data: 2019/3/23
 * Describe:
 */
public abstract class BaseFragment extends Fragment implements UiOperation {
    protected View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResID(), null);
        initView();
        initListener();
        initData();
        return rootView;
    }

    /**
     * 查找View，这个方法可以省去我们的强转操作
     *
     * @param id
     * @return
     */
    public <T> T findView(int id) {
        @SuppressWarnings("unchecked")
        T view = (T) rootView.findViewById(id);
        return view;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();// 处理共同操作
        if (i == R.id.base_btn_back) {
            getActivity().finish();

        } else {// 如果单击的不是返回按钮，则还是由子类去作处理
            onClick(v, v.getId());

        }
    }

}
