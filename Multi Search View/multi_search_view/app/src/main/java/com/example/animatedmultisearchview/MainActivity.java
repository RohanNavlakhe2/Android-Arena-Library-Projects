package com.example.animatedmultisearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.animatedmultisearchview.databinding.ActivityMainBinding;
import com.iammert.library.ui.multisearchviewlib.MultiSearchView;
//add Below dependencies to your app level gradle
   //implementation 'com.github.iammert:MultiSearchView:0.1'  (For SearchView)
   //implementation 'com.github.bumptech.glide:glide:4.11.0'  (For ImageLoading)
//add maven to your project level gradles allProjects->repositories section
   //maven { url 'https://jitpack.io'}
public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        //MultiSearchView multiSearchView=findViewById(R.id.multiSearchView);
        activityMainBinding.multiSearchView.setSearchViewListener(new MultiSearchView.MultiSearchViewListener() {
            @Override
            public void onTextChanged(int i, CharSequence charSequence) {
                Log.i("msearch","TextChanged:"+charSequence+"->"+i);

                //This method is called every time when user time some letter
            }

            @Override
            public void onSearchComplete(int i, CharSequence charSequence) {
                Log.i("msearch","Search Complete:"+charSequence+"->"+i);

                //This method is called when user press search icon when s/he finishes his/her query

                //when User will click on the search icon available on the soft keyboard then this
                //method will be called.
                //here we will load images based on the search query
                loadImgs(charSequence.toString());
            }

            @Override
            public void onSearchItemRemoved(int i) {
                Log.i("msearch","Search Item Removed:"+"->"+i);

                //this method is called When user press cross icon to remove some search query

            }

            @Override
            public void onItemSelected(int i, CharSequence charSequence) {
                Log.i("msearch","Item Selected:"+charSequence+"->"+i);

                //this method is called when user selects some search query

                //loading particular images based on the item selection
                loadImgs(charSequence.toString());

            }
        });





     }

    private void loadImgs(String searchString)
    {
        if(searchString.toString().equalsIgnoreCase("fashion"))
        {
            Glide.with(MainActivity.this)
                    .load(getResources().getDrawable(R.drawable.fashion1))
                    .into(activityMainBinding.img1);
            Glide.with(MainActivity.this)
                    .load(getResources().getDrawable(R.drawable.fashion2))
                    .into(activityMainBinding.img2);
            Glide.with(MainActivity.this)
                    .load(getResources().getDrawable(R.drawable.fashion3))
                    .into(activityMainBinding.img3);
        }
        else  if(searchString.toString().equalsIgnoreCase("travel"))
        {
            Glide.with(MainActivity.this)
                    .load(getResources().getDrawable(R.drawable.travel1))
                    .into(activityMainBinding.img1);
            Glide.with(MainActivity.this)
                    .load(getResources().getDrawable(R.drawable.travel2))
                    .into(activityMainBinding.img2);
            Glide.with(MainActivity.this)
                    .load(getResources().getDrawable(R.drawable.travel3))
                    .into(activityMainBinding.img3);
        }
    }
}
