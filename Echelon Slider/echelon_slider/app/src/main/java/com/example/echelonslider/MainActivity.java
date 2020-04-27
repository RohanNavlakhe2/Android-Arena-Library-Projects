package com.example.echelonslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.echelonslider.echelon.EchelonLayoutManager;
//Paste echelon package as it is in your project
//In MainActivity we will set up recycler view
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating RecyclerView Instance
        recyclerView=findViewById(R.id.recycler_view);
        initRec();



    }

    private void initRec()
    {
        //Setting Layout manger and adapter to RecyclerView

        //Here EchelonLayoutManager is a custom LayoutManger which extends LinearLayoutManger
        recyclerView.setLayoutManager(new EchelonLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
    }
}
