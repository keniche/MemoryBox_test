package com.android.ken.memorybox1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private int[] mImageList;

    public MyPagerAdapter(FragmentManager fm, int[] imageList) {
        super(fm);
        mImageList = imageList;
    }

    @Override
    public Fragment getItem(int position) {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
        args.putInt("image_id", mImageList[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return mImageList.length;
    }
}
