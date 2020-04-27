package com.example.youtubeplayer.youtube_video_rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.youtubeplayer.R;

public class YouTubeNativeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_native);

        //Getting data passed from YouTubeNativeActivity
        Bundle extras = getIntent().getExtras();

        YouTubeNativeFragment  youTubeNativeFragment  = new YouTubeNativeFragment ();
        youTubeNativeFragment.setArguments(extras);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, youTubeNativeFragment);
        fragmentTransaction.commit();
    }


}
