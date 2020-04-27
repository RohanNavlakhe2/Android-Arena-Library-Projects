package com.example.smartiestimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Before starting add below dependencies to your app level gradle
      //implementation 'com.github.smarteist:autoimageslider:1.3.2' (For slider)
     //implementation 'com.github.bumptech.glide:glide:4.11.0'    (For image Loading)

public class MainActivity extends AppCompatActivity {


    private SliderView imageSlider;
    private SliderView imageSlider2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider=findViewById(R.id.imageSlider);


        setUpSlider();

    }

    private void setUpSlider()
    {
        List<Integer> sliderImages= Arrays.asList(R.drawable.banner2, R.drawable.banner3, R.drawable.banner1,R.drawable.banner5,R.drawable.banner4);
        SliderAdapter adapter = new SliderAdapter(this,sliderImages);

         imageSlider.setSliderAdapter(adapter);

         imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);//set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
         imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
         imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
         imageSlider.setIndicatorSelectedColor(Color.WHITE);
         imageSlider.setIndicatorUnselectedColor(Color.GRAY);
         imageSlider.setScrollTimeInSec(2); //set scroll delay in seconds :
         imageSlider.startAutoCycle();

    }


}
