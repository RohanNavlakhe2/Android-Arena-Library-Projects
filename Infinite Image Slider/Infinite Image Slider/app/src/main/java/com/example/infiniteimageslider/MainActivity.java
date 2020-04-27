package com.example.infiniteimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.lightsky.infiniteindicator.IndicatorConfiguration;
import cn.lightsky.infiniteindicator.InfiniteIndicator;
import cn.lightsky.infiniteindicator.Page;

import static android.view.Gravity.RIGHT;

public class MainActivity extends AppCompatActivity {

    //Here Page is a class given by this Library
    private List<Page> sliderImages;
    private InfiniteIndicator infiniteIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderImages=new ArrayList<>();
        infiniteIndicator=findViewById(R.id.infinite_anim_circle);

        sliderImages.add(new Page(R.drawable.banner2));
        sliderImages.add(new Page(R.drawable.banner3));
        sliderImages.add(new Page(R.drawable.banner1));
        sliderImages.add(new Page(R.drawable.banner5));
        sliderImages.add(new Page(R.drawable.banner4));

        testAnimCircleIndicator();
    }

    private void testAnimCircleIndicator() {
        InfiniteIndicator mAnimCircleIndicator = infiniteIndicator;
        IndicatorConfiguration configuration = new IndicatorConfiguration.Builder()
                .imageLoader(new PicassoLoader())
                .isStopWhileTouch(true)
                .direction(RIGHT)
                .position(IndicatorConfiguration.IndicatorPosition.Center_Bottom)
                .build();

         /*Here PicassoLoader is a class which is responsible for image loading
         so paste this class to your projects and add the below dependency to
         your app level gradle.*/
            //implementation 'com.squareup.picasso:picasso:2.71828'


        mAnimCircleIndicator.init(configuration);
        mAnimCircleIndicator.notifyDataChange(sliderImages);
        mAnimCircleIndicator.setCurrentItem(0);
    }
}
