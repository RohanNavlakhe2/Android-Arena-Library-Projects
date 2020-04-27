package com.example.scratchcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//Add the below line in your "project" level gradle's repositories section
     // maven { url "https://jitpack.io" }
//Add the below line in your app level gradle's dependencies section
    //implementation 'com.github.AnupKumarPanwar:ScratchView:1.2'
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Nothing to do anything here
           //go directly to activity_main.xml
    }
}
