package com.garyhu.imagedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.garyhu.imagedemo.widget.NewViewWidget;
import com.garyhu.imagedemo.R;

import java.util.Calendar;

/**
 * 作者： garyhu.
 * 时间： 2016/10/24.
 */
public class ThirdActivity extends AppCompatActivity {

    private TextView weekText;
    private TextView dateText;
    private NewViewWidget newWidget;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        weekText = ((TextView) findViewById(R.id.week));
        dateText = ((TextView) findViewById(R.id.date));
        newWidget = ((NewViewWidget) findViewById(R.id.new_widget));

        getDate();
    }

    //获取当前日期
    public void getDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        dateText.setText(year+"-"+(month+1)+"-"+day);

        int week = cal.get(Calendar.DAY_OF_WEEK);
        if(week==1){
            weekText.setText("星期日");
        }else if(week==2){
            weekText.setText("星期一");
        }else if(week==3){
            weekText.setText("星期二");
        }else if(week==4){
            weekText.setText("星期三");
        }else if(week==5){
            weekText.setText("星期四");
        }else if(week==6){
            weekText.setText("星期五");
        }else if(week==7){
            weekText.setText("星期六");
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
