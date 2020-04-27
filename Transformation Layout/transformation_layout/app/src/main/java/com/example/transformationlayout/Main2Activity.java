package com.example.transformationlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.transformationlayout.databinding.ActivityMain2Binding;
import com.skydoves.transformationlayout.TransformationLayout;
import com.skydoves.transformationlayout.TransitionExtensionKt;

public class Main2Activity extends AppCompatActivity {

    private ActivityMain2Binding activityMain2Binding;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         //Here We are catching the data passed from the intent from MainActivity
        TransformationLayout.Params params = getIntent().getParcelableExtra("TransformationParams");

         //onTransformationEndContainer() method will be called before the onCreate() method super call of
         // the target Activity (Transformed Activity)
        TransitionExtensionKt.onTransformationEndContainer(this, params);
        super.onCreate(savedInstanceState);
        activityMain2Binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);

        activityMain2Binding.bringSignupFormBtn.setOnClickListener(v->{
              //Call startTransform() method and pass root element as an argument to start Transformation.
                activityMain2Binding.transformationLayout.startTransform(activityMain2Binding.parent);

                //Making Login Form Gone because now Signup Form will appear as we called startTransform().
                //Because In Xml Sign up has been bound as targetView to the Transformation Layout.
               activityMain2Binding.logInSection.setVisibility(View.GONE);

               //Making Login Here  Button Visible
                activityMain2Binding.bringLoginFormBtn.setVisibility(View.VISIBLE);

        });

        activityMain2Binding.bringLoginFormBtn.setOnClickListener(v->{
            //Making Login Form Visible
            activityMain2Binding.logInSection.setVisibility(View.VISIBLE);

            //calling finishTransform() to goto the initial Login Form View
            activityMain2Binding.transformationLayout.finishTransform(activityMain2Binding.parent);

            //Hiding Login Here Button
            activityMain2Binding.bringLoginFormBtn.setVisibility(View.GONE);
        });

    }
}
