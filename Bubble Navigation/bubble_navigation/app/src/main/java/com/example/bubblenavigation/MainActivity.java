package com.example.bubblenavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BubbleNavigationLinearView bubbleNavigationLinearView=findViewById(R.id.bubbleNav);

        //set up listener on BubbleNavigationView
        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position)
                {
                    case 0:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment).navigate(R.id.navigation_home);
                        break;
                    case 1:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment).navigate(R.id.navigation_notification);
                        break;
                    case 2:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment).navigate(R.id.navigation_location);
                        break;
                    case 3:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment).navigate(R.id.navigation_profile);
                        break;
                }
            }
        });








    }
}
