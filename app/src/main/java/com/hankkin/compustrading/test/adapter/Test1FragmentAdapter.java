package com.hankkin.compustrading.test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hankkin.compustrading.model.Category;
import com.hankkin.compustrading.test.views.Test1Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hankkin on 15/11/29.
 */
public class Test1FragmentAdapter extends FragmentPagerAdapter {

    private List<Test1Fragment> fragments;
    private ArrayList<Category> categories;

    public Test1FragmentAdapter(FragmentManager fm, List<Test1Fragment> fragments, ArrayList<Category> categories) {
        super(fm);
        this.fragments = fragments;
        this.categories = categories;
    }

    public Test1FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    public String getPageTitle(int i){
        return categories.get(i).getName();
    }
}
