package com.hankkin.compustrading.test.views;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.demonstrate.DemonstrateUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.hankkin.compustrading.R;
import com.hankkin.compustrading.model.Category;
import com.hankkin.compustrading.test.adapter.Test1FragmentAdapter;
import com.hankkin.compustrading.view.PagerSlidingTabStrip;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class Test1Activity extends AppCompatActivity {

    /**
     * 分类滑动选项卡
     */
    private PagerSlidingTabStrip pagerTab;
    /**
     * 滑动组件
     */
    private ViewPager pager;
    /**
     * 选项fragment界面
     */
    private ArrayList<Test1Fragment> fragments;

    /**
     * 分类数组
     */
    private ArrayList<Category> categories = new ArrayList<>();
    /**
     * 分类界面适配器
     */
    private Test1FragmentAdapter adapter;

    private Gson gson;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);
        gson = new Gson();
        Fresco.initialize(this);
        init();

//        request();
        refresh();

    }


    private void refresh() {
        categories
                .add(new Category(0, "数码", "", 1));

        categories
                .add(new Category(1, "书籍", "", 1));

        categories
                .add(new Category(2, "运动", "", 1));

        categories
                .add(new Category(3, "生活", "", 1));

        categories
                .add(new Category(4, "其他", "", 1));

        for (int i = 0; i < categories.size(); i++) {
            Test1Fragment fragment = new Test1Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("cid", categories.get(i).getId());
//            bundle.putSerializable("products", (Serializable) msg.obj);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        adapter = new Test1FragmentAdapter(getSupportFragmentManager(), fragments, categories);
        pager.setAdapter(adapter);
        pagerTab.setViewPager(pager);
    }

    /**
     * 初始化数据
     * by Hankkin at:2015-11-29 19:29:52
     */
    private void init() {
        //设定左上角突变可点击
        getSupportActionBar().setHomeButtonEnabled(true);
        // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置标题
        getSupportActionBar().setTitle(getResources().getString(R.string.action_title));

//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.topbar_qiehuan);
//        getSupportActionBar().setIcon(R.drawable.topbar_qiehuan);
        pager = (ViewPager) findViewById(R.id.pager);
        pagerTab = (PagerSlidingTabStrip) findViewById(R.id.tab);

        pager.setOffscreenPageLimit(4);
        fragments = new ArrayList<>();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_person) {
            DemonstrateUtil.showToastResult(this, "个人中心");
        } else if (id == android.R.id.home) {
            DemonstrateUtil.showToastResult(this, "返回");
        }
        return super.onOptionsItemSelected(item);
    }
}
