package com.example.echelonslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterInner> {
    //replace these icons with your own one which you want to display in circle at top
    private int[] icons = {R.drawable.header_icon_1,R.drawable.header_icon_2,R.drawable.header_icon_3,R.drawable.header_icon_4,R.drawable.header_icon_1,R.drawable.header_icon_2,R.drawable.header_icon_3,R.drawable.header_icon_4};
    //replace these Images with your own one which you want to display as main big images
    private int[] bgs = {R.drawable.bg_1,R.drawable.bg_2,R.drawable.bg_3,R.drawable.bg_4,R.drawable.bg_1,R.drawable.bg_2,R.drawable.bg_3,R.drawable.bg_4};
    //These are the names which will display at top
    private String[] nickNames = {"Rohan","Abhi","John","Amaya","Rohan","Abhi","John","Amaya"};
    //Theres are description text
    private String[] descs = {"Desc1","Desc2","Desc3","Desc4","Desc1","Desc2","Desc3","Desc4"};

    @NonNull
    @Override
    public MyAdapterInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Make your layout in item_echelon
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_echelon,parent,false);
        return new MyAdapterInner(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterInner holder, int position) {
        holder.icon.setImageResource(icons[position]);
        holder.nickName.setText(nickNames[position]);
        holder.desc.setText(descs[position]);
        holder.bg.setImageResource(bgs[position]);
    }

    @Override
    public int getItemCount() {
        return icons.length;
    }

    class MyAdapterInner extends RecyclerView.ViewHolder {
        ImageView icon;
        ImageView bg;
        TextView nickName;
        TextView desc;
        public MyAdapterInner(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.img_icon);
            bg = itemView.findViewById(R.id.img_bg);
            nickName = itemView.findViewById(R.id.tv_nickname);
            desc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
