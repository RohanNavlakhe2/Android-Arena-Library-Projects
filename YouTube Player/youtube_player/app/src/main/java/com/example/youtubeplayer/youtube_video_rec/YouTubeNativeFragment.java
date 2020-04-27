package com.example.youtubeplayer.youtube_video_rec;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youtubeplayer.R;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class YouTubeNativeFragment extends Fragment {

    private int youtubePlayerType;
    private RecyclerView recyclerView;

    public YouTubeNativeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_you_tube_native, container, false);
         recyclerView=view.findViewById(R.id.youtubeRec);

        Bundle arguments = getArguments();
        youtubePlayerType=arguments.getInt("playerType");

        initYoutubeRec();
         return view;
    }

    private void initYoutubeRec()
    {
        List<String> videoIds= Arrays.asList("2Vv-BfVoq4g","D5drYkLiLI8","K0ibBPhiaG0","ebXbLfLACGM","mWRsgZuwf_8");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new YouTubePlayerAdapter(videoIds,this,youtubePlayerType));

    }
}
