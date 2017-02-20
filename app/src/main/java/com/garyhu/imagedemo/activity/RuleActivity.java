package com.garyhu.imagedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.garyhu.imagedemo.R;
import com.garyhu.imagedemo.widget.RulerView;

/**
 * 作者： garyhu.
 * 时间： 2017/2/20.
 */

public class RuleActivity extends AppCompatActivity {

    private RulerView ruler_height;   //身高的view
    private RulerView ruler_weight ;  //体重的view
    private TextView tv_register_info_height_value,tv_register_info_weight_value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        ruler_height=(RulerView)findViewById(R.id.ruler_height);
        ruler_weight=(RulerView)findViewById(R.id.ruler_weight);

        tv_register_info_height_value=(TextView) findViewById(R.id.tv_register_info_height_value);
        tv_register_info_weight_value=(TextView) findViewById(R.id.tv_register_info_weight_value);


        ruler_height.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tv_register_info_height_value.setText(value+"");
            }
        });


        ruler_weight.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tv_register_info_weight_value.setText(value+"");
            }
        });

        ruler_height.setValue(165, 80, 250, 1);

        ruler_weight.setValue(55, 20, 200, 0.1f);
    }
}
