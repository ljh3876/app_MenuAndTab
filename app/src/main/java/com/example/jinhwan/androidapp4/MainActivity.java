package com.example.jinhwan.androidapp4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    LinearLayout main;
    FrameLayout.LayoutParams params_c,params_s;
    TextView text_c,text_s;
    ImageView image_c,image_s;
    MenuItem item_c, item_s,item_twice,item_title,item_b,item_r,item_y,item_rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요.");
        initActivity();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        initMenu(menu);
        return true;
    }
    void initActivity(){
        main=(LinearLayout)findViewById(R.id.activity_main);
        text_c=(TextView)findViewById(R.id.textView_chicken);
        text_s=(TextView)findViewById(R.id.textView_spaghetti);
        image_c=(ImageView)findViewById(R.id.imageView_chicken);
        image_s=(ImageView)findViewById(R.id.imageView_spaghetti);
    }
    void initMenu(Menu menu){
        item_c=menu.findItem(R.id.item_chicken);
        item_s=menu.findItem(R.id.item_spaghetti);
        item_title=menu.findItem(R.id.item_title);
        item_twice=menu.findItem(R.id.item_twice);
        item_rotate=menu.findItem(R.id.item_rotate);
        params_c= (FrameLayout.LayoutParams) image_c.getLayoutParams();
        params_s= (FrameLayout.LayoutParams) image_s.getLayoutParams();
    }
    int index=1;
    float rotate=0;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.item_chicken :
                index=1;
                item.setChecked(true);
                visible(image_c,image_s,index);
                if(item_title.isChecked())
                    visible(text_c,text_s,index);
                break;

            case R.id.item_spaghetti :
                index=2;
                item.setChecked(true);
                visible(image_c,image_s,index);
                if(item_title.isChecked())
                    visible(text_c,text_s,index);
                break;
            case R.id.item_title:
                if(item.isChecked()) {
                    text_c.setVisibility(View.GONE);
                    text_s.setVisibility(View.GONE);
                    item.setChecked(false);
                }
                else{
                    visible(text_c,text_s,index);
                    item.setChecked(true);
                }
                break;
            case R.id.item_twice:

                if(item.isChecked()){
                    item.setChecked(false);
                    changeSize(400);
                }else{
                    item.setChecked(true);
                    changeSize(800);
                }
                break;
            case R.id.item_rotate:
                rotate+=30;
                image_c.setRotation(rotate);
                image_s.setRotation(rotate);
                break;
            default :
                if(item.getItemId()==R.id.item_red)
                    main.setBackgroundColor(Color.RED);
                else if(item.getItemId() == R.id.item_blue)
                    main.setBackgroundColor(Color.BLUE);
                else if(item.getItemId() == R.id.item_yellow)
                    main.setBackgroundColor(Color.YELLOW);
        }
        return super.onOptionsItemSelected(item);
    }

    public void visible(ImageView chick,ImageView spa,int index) {
        if(index ==1){
            chick.setVisibility(View.VISIBLE);
            spa.setVisibility(View.GONE);
        }else{
            chick.setVisibility(View.GONE);
            spa.setVisibility(View.VISIBLE);
        }
    }
    public void visible(TextView chick,TextView spa,int index) {
        if(index ==1){
            chick.setVisibility(View.VISIBLE);
            spa.setVisibility(View.GONE);
        }else{
            chick.setVisibility(View.GONE);
            spa.setVisibility(View.VISIBLE);
        }
    }
    public void changeSize(int size){
        params_c.width=size;
        params_c.height=size;
        params_s.width=size;
        params_s.height=size;
        image_c.setLayoutParams(params_c);
        image_s.setLayoutParams(params_s);
    }
}
