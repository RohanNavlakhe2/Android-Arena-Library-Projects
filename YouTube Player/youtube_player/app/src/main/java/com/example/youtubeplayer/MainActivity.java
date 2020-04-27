package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.youtubeplayer.util.Constants;
import com.example.youtubeplayer.youtube_video_rec.YouTubeNativeActivity;
import com.flipkart.youtubeview.activity.YouTubeActivity;
import com.flipkart.youtubeview.models.YouTubePlayerType;
//Add this to your app level gradle:
   //For Youtubeplayer:   implementation 'com.github.flipkart-incubator:android-inline-youtube-view:1.0.3'
   //Picasso          :   implementation 'com.squareup.picasso:picasso:2.71828'

//Add this to your project level gradle's allprojects->repositories section
    //maven { url "https://jitpack.io" }
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Opening FullScreen Activity
        findViewById(R.id.youtubeFullActivityBtn).setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, YouTubeActivity.class);
            //Your Api Key (See how to generate your own Api Key in Constants class)
            intent.putExtra("apiKey", Constants.API_KEY);
            //Video ID of a youtube video you want to play
            intent.putExtra("videoId", "3AtDnEC4zak");
            startActivity(intent);
        });

        //Opening YouTubeNativeActivity which contains YouTubeNativeFragment which contains
        //RecyclerView to show videos

        //To enable this type of view you can paste the following files directly to your project.
           //1. YouTubeNativeActivity.class -> activity_you_tube_native.xml
                //make sure to add this to your manifest file also
           //2 YouTubeNativeFragment.class  -> fragment_you_tube_native.xml
           //3.YouTubePlayerAdapter.class   -> youtube_rec.xml
        findViewById(R.id.youtubeRecyclerBtn).setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, YouTubeNativeActivity.class);
            intent.putExtra("playerType", YouTubePlayerType.STRICT_NATIVE);
            startActivity(intent);
        });
    }
}
