package com.android.ken.memorybox1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;



public class AddActivity extends AppCompatActivity {
    static final int REQUEST_CODE_GALLERY = 1;
    static final int REQUEST_CODE_CAMERA = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);



        int[] imageList ={R.drawable.icon_grey_1,
                R.drawable.icon_grey_2,
                R.drawable.icon_grey_3,
                R.drawable.icon_grey_4,
                R.drawable.icon_grey_5};

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), imageList);
        viewPager.setAdapter(pagerAdapter);

    }

    //ギャラリーとカメラから情報を取ってくるメソッド




}