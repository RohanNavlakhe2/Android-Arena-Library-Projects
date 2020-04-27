package com.example.transformationlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.skydoves.transformationlayout.TransformationLayout;
import com.skydoves.transformationlayout.TransitionExtensionKt;
//Add the below line to your app level gradle:
   //    implementation "com.github.skydoves:transformationlayout:1.0.1"
public class MainActivity extends AppCompatActivity {

    private TransformationLayout transformationLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //method onTransformationStartContainer() will be called inside the Activity where the view which
        // will be transformed into a new activity is available.(In this case that view is fab)

        //Remember that this method will always be called before onCreate() super call
        TransitionExtensionKt.onTransformationStartContainer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TransformationLayout given by the library
        transformationLayout=findViewById(R.id.transformationLayout);

        findViewById(R.id.fab).setOnClickListener(v->{
            //Now on Click the view to transform the view into an activity add below lines

            //First create a Bundle
            Bundle bundle = transformationLayout.withActivity(this, "myTransitionName");
            Intent intent = new Intent(this, Main2Activity.class);
            //Now put data into intent
            intent.putExtra("TransformationParams", transformationLayout.getParcelableParams());
            startActivity(intent, bundle);
        });
    }
}
