/*
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION
 *
 * Copyright (c) 2018 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.example.youtubeplayer.youtube_video_rec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplayer.util.Constants;
import com.example.youtubeplayer.R;
import com.flipkart.youtubeview.YouTubePlayerView;
import com.flipkart.youtubeview.models.ImageLoader;
import com.squareup.picasso.Picasso;


import java.util.List;

public class YouTubePlayerAdapter extends RecyclerView.Adapter<YouTubePlayerAdapter.YouTubePlayerViewHolder> {

    private List<String> videoIds;
    private Fragment fragment;
    private int playerType;

    //To load Video Thumbnail
    private ImageLoader imageLoader = new ImageLoader() {
        @Override
        public void loadImage(@NonNull ImageView imageView, @NonNull String url, int height, int width) {
            Picasso.get().load(url).resize(width, height).centerCrop().into(imageView);
         }
    };


     YouTubePlayerAdapter(List<String> videoIds, Fragment fragment, int playerType) {
       this.videoIds = videoIds;
         this.fragment = fragment;
        this.playerType = playerType;
    }

    @Override
    public int getItemCount() {
        return videoIds.size();
    }

    @NonNull
    @Override
    public YouTubePlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_rec, parent, false);
        return new YouTubePlayerViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final YouTubePlayerViewHolder holder, int position) {
        YouTubePlayerView playerView = holder.playerView;
        String videoId = videoIds.get(position);

        playerView.initPlayer(Constants.API_KEY, videoId, "https://cdn.rawgit.com/flipkart-incubator/inline-youtube-view/60bae1a1/youtube-android/youtube_iframe_player.html", playerType, null,fragment, imageLoader);
    }

    static class YouTubePlayerViewHolder extends RecyclerView.ViewHolder {
        YouTubePlayerView playerView;

        YouTubePlayerViewHolder(View view) {
            super(view);
            playerView = view.findViewById(R.id.youtube_player_view);
        }
    }
}
