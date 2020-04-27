package com.example.likebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.like.LikeButton;
import com.like.OnLikeListener;
//Before Start
/* Add the below line in your "project" level gradle's repositories section
         maven { url "https://jitpack.io"
  Add the below line in your app level gradle's dependencies section
         implementation 'com.github.jd-alexander:LikeButton:0.2.3'*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LikeButton likeButton=findViewById(R.id.heart_button);

        likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                //put the action on like
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                //put the action on unlike
            }
        });
    }
}
