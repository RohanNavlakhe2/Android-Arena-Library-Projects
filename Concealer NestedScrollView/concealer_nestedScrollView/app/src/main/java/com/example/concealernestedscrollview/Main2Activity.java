package com.example.concealernestedscrollview;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.simmorsal.library.ConcealerNestedScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
//Add this dependency to your app level gradle:
  //implementation 'com.simmorsal.library:concealer_nested_scroll_view:2.0.0'
  //check out the activity_main2.xml first
public class Main2Activity extends AppCompatActivity {

    private ConcealerNestedScrollView concealerNestedScrollView;
    private TextView headerTextview;
    private BottomNavigationView bottomNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Here BottomNavigationView is our footer view
        bottomNavView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavView, navController);

      //setting Concealer Scroll View
        settingConcealerScrollView();
    }

    private void settingConcealerScrollView()
    {
        concealerNestedScrollView=findViewById(R.id.concealerNestedScrollView);
        headerTextview=findViewById(R.id.header);

        /*Setting header view to ConcealerNestedScrollView and its marginTop*/
        headerTextview.post(()->{
            concealerNestedScrollView.setHeaderView(headerTextview,40);
        });

        /*Setting footer view to ConcealerNestedScrollView and its marginBottom*/
        bottomNavView.post(()->{
            concealerNestedScrollView.setFooterView(bottomNavView,0);
        });
    }

}
