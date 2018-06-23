package com.hankkin.compustrading.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hankkin.compustrading.R;
import com.hankkin.compustrading.Utils.HankkinUtils;
import com.hankkin.compustrading.model.Person;
import com.hankkin.compustrading.sharepreference.MySP;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.et_login_name)
    EditText etName;
    @BindView(R.id.et_login_pwd)
    EditText etPwd;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.pw_loading)
    ProgressWheel wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        initViews();
    }

    private void initViews(){
        wheel.stopSpinning();
    }

    /**
     * 注册用户
     * by Hankkin at:2015-12-20 21:13:02
     */
    @OnClick(R.id.btn_register)
    public void register(View view){
        wheel.spin();
        final String name = etName.getText().toString().trim();
        final String pwd = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            HankkinUtils.showToast(RegisterActivity.this,"用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            HankkinUtils.showToast(RegisterActivity.this,"密码不能为空");
            return;
        }
        if (!HankkinUtils.isMobileNO(name)){
            HankkinUtils.showToast(RegisterActivity.this,"请输入正确的手机号");
            return;
        }
        Person person = new Person();
        person.setUsername(name);
        person.setPassword(pwd);
        person.signUp(new SaveListener<Object>() {
            @Override
            public void done(Object o, BmobException e) {
                if (e == null){
                    MySP.setPASSWoRD(RegisterActivity.this,pwd);
                    MySP.setUSERNAME(RegisterActivity.this, name);
                    wheel.stopSpinning();
                    HankkinUtils.showToast(RegisterActivity.this, "注册成功");
                    Intent intent = new Intent(RegisterActivity.this,MainShowActivity.class);
                    startActivity(intent);
                    finish();
                    if (LoginActivity.instance!=null){
                        LoginActivity.instance.finish();
                    }
                    if (PersonActivity.instance!=null){
                        PersonActivity.instance.finish();
                    }
                    if (MainShowActivity.instance!=null){
                        MainShowActivity.instance.finish();
                    }
                    BmobUser.loginByAccount("username", "用户密码", new LogInListener<Person>() {
                        @Override
                        public void done(Person person, BmobException e) {
                            if (e == null){

                            }
                        }
                    });
                }
                else {
                    wheel.stopSpinning();
                    HankkinUtils.showToast(RegisterActivity.this, "注册失败");
                }
            }
        });
    }

    @OnClick(R.id.tv_back)
    void back(){
        finish();
    }


}
