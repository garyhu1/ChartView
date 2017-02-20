package com.garyhu.imagedemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.garyhu.imagedemo.R;
import com.garyhu.imagedemo.widget.CustomProgressBar;

public class MainActivity extends AppCompatActivity {


    private Button jumpBtn;
    private Button newBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private CustomProgressBar cusProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumpBtn = ((Button) findViewById(R.id.btn));
        newBtn = (Button) findViewById(R.id.new_btn);
        fourBtn = (Button) findViewById(R.id.btn_four);
        fiveBtn = ((Button) findViewById(R.id.btn_five));
        sixBtn = ((Button) findViewById(R.id.btn_six));
        cusProgress = ((CustomProgressBar) findViewById(R.id.cus_progress));

        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FourActivity.class);
                startActivity(intent);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FiveActivity.class);
                startActivity(intent);
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SixActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cusProgress.setIsShow(false)
                        .setmTitle("施工进度")
                        .setSubTitle("还未开始")
//                        .setPercent(73)
                        .start();
//                jump();
            }
        });

        findViewById(R.id.rule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RuleActivity.class));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("ddd","why");
    }

    public void jump(){
        Uri uri = Uri.parse("http://gwnew.miaodj.cn/activity/20170207/sh/active.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
