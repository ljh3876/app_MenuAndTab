package com.example.jinhwan.androidapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    TabHost tabHost;
    Button btn,btn2,btn3 ;
    EditText height,weight,area;
    TextView init,done,calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");
        init();
    }
    public void init(){
        tabHost=(TabHost)findViewById(R.id.tab);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("calc1").setContent(R.id.tab1).setIndicator("BMI 계산기"));
        tabHost.addTab(tabHost.newTabSpec("calc2").setContent(R.id.tab2).setIndicator("면적 계산기"));

        btn=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        height=(EditText)findViewById(R.id.editText_height);
        weight=(EditText)findViewById(R.id.editText_weight);
        area=(EditText)findViewById(R.id.area);
        init = (TextView)findViewById(R.id.textBottom_init);
        done = (TextView)findViewById(R.id.textBottom_done);
        calc = (TextView)findViewById(R.id.text_calc);
    }
    double num_weight,num_height,result;
    double num_area,result2;
    public void myOnClick(View v){
        switch(v.getId()){
            case R.id.button :
                if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"빈칸을 모두 채우세요.", Toast.LENGTH_SHORT).show();
                else
                {
                    num_weight = Double.parseDouble(weight.getText().toString());
                    num_height = Double.parseDouble(height.getText().toString())/100;
                    result=num_weight/(num_height*num_height);
                    init.setVisibility(View.GONE);
                    if(result>=25.0){
                        done.setText("비만입니다.");
                        done.setVisibility(View.VISIBLE);
                    }else if(24.9>result && result>=23.0){
                        done.setText("과체중입니다.");
                        done.setVisibility(View.VISIBLE);
                    }else if(22.9>result && result>=18.5) {
                        done.setText("정상입니다.");
                        done.setVisibility(View.VISIBLE);
                    }else{
                        done.setText("체중부족입니다.");
                        done.setVisibility(View.VISIBLE);

                    }
                    break;
                }
            case R.id.button2 :
                if(area.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"빈칸을 모두 채우세요.", Toast.LENGTH_SHORT).show();
                else
                {
                    num_area = Double.parseDouble(area.getText().toString());
                    result2 = num_area*3.305785;
                    calc.setText(result2+" 제곱미터");
                }
                break;
            case R.id.button3:
                if(area.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"빈칸을 모두 채우세요.", Toast.LENGTH_SHORT).show();
                else
                {
                    num_area = Double.parseDouble(area.getText().toString());
                    result2 = num_area*0.3025;
                    calc.setText(result2+" 평");
                }
                break;
        }
    }
}
