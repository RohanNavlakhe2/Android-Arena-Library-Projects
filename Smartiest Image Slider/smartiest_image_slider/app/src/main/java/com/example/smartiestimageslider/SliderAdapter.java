package com.example.smartiestimageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<Integer> sliderImages;

    public SliderAdapter(Context context,List<Integer> sliderImages) {
        this.context = context;
        this.sliderImages=sliderImages;

    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        //You can customize your layout style you want to show in slider in small_banner_style.xml
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.small_banner_style, parent, false);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Glide.with(context).load(sliderImages.get(position)).into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return sliderImages.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;


        SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageViewBanner);
            this.itemView = itemView;
        }
    }
}