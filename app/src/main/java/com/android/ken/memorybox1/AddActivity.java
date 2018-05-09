package com.android.ken.memorybox1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class AddActivity extends AppCompatActivity {

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
        //imageList[] = [「URIの個数.length」];
        //ギャラリーから持ってきたURIを入れていく？
        //→とりあえず、半透明の画像をセットしといて、fragmentのonclickをしてギャラリーに飛べるようにする
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), imageList);
        viewPager.setAdapter(pagerAdapter);
    }
}