package com.bwie.newsdemo;

import android.graphics.Color;

import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragment.HomeFragment;
import fragment.VideoFragment;
import fragment.CareFragment;
import fragment.LoginFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_care;
    private LinearLayout ll_home;
    private LinearLayout ll_login;
    private LinearLayout ll_tv;
    private ImageView im_home;
    private ImageView im_tv;
    private ImageView im_care;
    private ImageView im_login;
    private TextView te_home;
    private TextView te_tv;
    private TextView te_care;
    private TextView te_login;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initView();
        //初始化底部按钮事件
        initEvent();
    }


    //初始化视图
    private void initView() {
        //下部四个线性布局的id
        ll_care = (LinearLayout) findViewById(R.id.ll_care);
        ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_login = (LinearLayout) findViewById(R.id.ll_login);
        ll_tv = (LinearLayout) findViewById(R.id.ll_tv);

        //下方按钮图片的id
        im_home = (ImageView) findViewById(R.id.im_home);
        im_tv = (ImageView) findViewById(R.id.im_tv);
        im_care = (ImageView) findViewById(R.id.im_care);
        im_login = (ImageView) findViewById(R.id.im_login);

        //下方的菜单字的id
        te_home = (TextView) findViewById(R.id.te_home);
        te_tv = (TextView) findViewById(R.id.te_tv);
        te_care = (TextView) findViewById(R.id.te_care);
        te_login = (TextView) findViewById(R.id.te_login);

        //默认显示第一个Fragment
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl, new HomeFragment()).commit();
    }

    private void initEvent() {
        ll_care.setOnClickListener(this);
        ll_home.setOnClickListener(this);
        ll_login.setOnClickListener(this);
        ll_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //点击后将所有的按钮设置为黑色
        restartButton();
        switch (v.getId()) {
            case R.id.ll_home:
                im_home.setImageResource(R.drawable.b_newhome_tabbar_press);
                te_home.setTextColor(Color.RED);
                manager.beginTransaction().replace(R.id.fl, new HomeFragment()).commit();
                break;
            case R.id.ll_tv:
                im_tv.setImageResource(R.drawable.b_newvideo_tabbar_press);
                te_tv.setTextColor(Color.RED);
                manager.beginTransaction().replace(R.id.fl, new VideoFragment()).commit();
                break;
            case R.id.ll_care:
                im_care.setImageResource(R.drawable.b_newcare_tabbar_press);
                te_care.setTextColor(Color.RED);
                manager.beginTransaction().replace(R.id.fl, new CareFragment()).commit();
                break;
            case R.id.ll_login:
                im_login.setImageResource(R.drawable.b_newnologin_tabbar_press);
                te_login.setTextColor(Color.RED);
                manager.beginTransaction().replace(R.id.fl, new LoginFragment()).commit();
                break;
        }
    }

    //点击后将所有的按钮变为灰色
    private void restartButton() {
        //image
        im_care.setImageResource(R.drawable.b_newcare_tabbar);
        im_home.setImageResource(R.drawable.b_newhome_tabbar);
        im_tv.setImageResource(R.drawable.b_newvideo_tabbar);
        im_login.setImageResource(R.drawable.b_newnologin_tabbar);
        //text
        //字体设置为黑色
        te_home.setTextColor(Color.GRAY);
        te_tv.setTextColor(Color.GRAY);
        te_care.setTextColor(Color.GRAY);
        te_login.setTextColor(Color.GRAY);
    }
}
