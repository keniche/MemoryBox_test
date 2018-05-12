package com.android.ken.memorybox1;

import android.app.Application;

import io.realm.Realm;


public class MemoryApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(getApplicationContext());
    }
}
