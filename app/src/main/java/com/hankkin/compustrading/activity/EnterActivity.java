package com.hankkin.compustrading.activity;

import com.example.demonstrate.DialogPage;
import com.example.demonstrate.FirstActivity;
import com.hankkin.compustrading.listener.ItemLis1;

public class EnterActivity extends FirstActivity {


    @Override
    protected void click0() {
        DialogPage
                .getInstance()
                .setOnDialogItemListener(new ItemLis1(this));
    }
}
