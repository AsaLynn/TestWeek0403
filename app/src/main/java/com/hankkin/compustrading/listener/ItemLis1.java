package com.hankkin.compustrading.listener;

import android.app.Activity;

import com.example.demonstrate.adapter.testname.p1.w3.BaseT4P1W3ILis;
import com.hankkin.compustrading.R;
import com.hankkin.compustrading.activity.SplasActivity;
import com.hankkin.compustrading.test.views.Test1Activity;

/**
 * Created by think on 2018/3/20.
 * 第一列表对话框条目监听.
 */

public class ItemLis1 extends BaseT4P1W3ILis {


    public ItemLis1(Activity activity) {
        super(activity);
    }

    @Override
    public Class<?> getStartActivity(int which) {
        if (which == 0) {
            return Test1Activity.class;
        } else if (which == 1) {
            return SplasActivity.class;
        } else if (which == 2) {
            return null;
        }
        return null;
    }

    @Override
    public int getDialogListId() {
        return R.array.test4_week3_dialog1_items;
    }
}
