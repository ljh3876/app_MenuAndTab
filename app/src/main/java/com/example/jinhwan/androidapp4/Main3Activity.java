package com.example.jinhwan.androidapp4;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class Main3Activity extends ActivityGroup{
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
    }
    public void init(){
        tabHost=(TabHost)findViewById(R.id.host);
        tabHost.setup(getLocalActivityManager());
        tabHost.addTab(tabHost.newTabSpec("Main1").setContent(new Intent(this,MainActivity.class)).setIndicator("메뉴연습"));
        tabHost.addTab(tabHost.newTabSpec("Main2").setContent(new Intent(this,Main2Activity.class)).setIndicator("계산기"));
        tabHost.setCurrentTab(0);
    }
}
