package com.garyhu.imagedemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.garyhu.imagedemo.R;

/**
 * 作者： garyhu.
 * 时间： 2016/10/25.
 */
public class FourActivity extends AppCompatActivity {


    private SimpleDraweeView sdv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_four);

        sdv = ((SimpleDraweeView) findViewById(R.id.sdv));

        String url = "http://tupian.enterdesk.com/2015/mxy/4/14/35/10.jpg";

        sdv.setImageURI(Uri.parse(url));
    }
}
