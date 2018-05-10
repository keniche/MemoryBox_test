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

import io.realm.Realm;


public class AddActivity extends AppCompatActivity {
    static final int REQUEST_CODE_GALLERY = 1;
    static final int REQUEST_CODE_CAMERA = 2;

    public Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);

        realm = Realm.getDefaultInstance();

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

        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
        });

        /*
        //onClickメソッド。
        //TODO:Fragmentの変数の取得方法？それさえわかれば、全部うまく行く。
        ImageView icon_grey_1 = (ImageView) findViewById(R.id.icon_grey_1);

        // Set a click listener on that View
        button.setOnClickListener(new View.OnClickListener{

            @Override
            public void onClick(View view) {
                // do something when the button is clicked
            }
        }); */
    }

    //ギャラリーとカメラから情報を取ってくるメソッド


    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_GALLERY) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(intent.getData());
                Bitmap bmp = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                ViewPager.setImageBitmap(bmp);
                //TODO:この、「ViewPager」が違う。上手くいかん。

            } catch (Exception e) {
                Toast.makeText(AddActivity.this, "エラー", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == REQUEST_CODE_CAMERA) {
            Bitmap bmp = (Bitmap) intent.getExtras().get("data");
            imageView.setImageBitmap(bmp);
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(AddActivity.this, "CANCEL", Toast.LENGTH_LONG).show();
        }
    }

    public void save(/*TODO:保存するものの引数いれる*/){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Memory memory = realm.createObject(Memory.class);
                //TODO:保存するものの変数"memory.◯◯ = ◯◯"
            }
        });
    }

    /*
    public void add (View v){
        save(/*TODO:保存するものの引数いれる*/);

        finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        realm.close();
    }
}