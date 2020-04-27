package com.example.magicalfabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.magicalfabs.databinding.ActivityMainBinding;
 //Steps:
 //1. First create a resource directory anim to your res folder by:
         //right click on res dir->new->android resource directory->give name anim->select anim from the dropdown
 //2. paste the four animation xmls from the anim folder of this project into your project.
 //3. paste the activity_main xml code to your project.
 //4. Now load the animations into java file using AnimationUtils.loadAnimation(context,animFile)
 //5. define the onClick listener for your main fab and show the fabs or hide them (see below code).
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private Animation FabOpen, FabClose, FabRClockwise, FabRantiClokwise;
    private boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        //loading animations from xml to java
        FabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise);
        FabRantiClokwise = AnimationUtils.loadAnimation(this, R.anim.roate_anticlock_wise);

        //onClick listener for main fab
        //initially isOpen is false means first time else condition will run which will
        //show the 2 hidden fabs.
        activityMainBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    //if fab is open then the below code will hide the remainig two fabs.
                    //fab1
                    activityMainBinding.fab1Lyt.startAnimation(FabClose);
                    activityMainBinding.fab1Lyt.setVisibility(View.GONE);
                    activityMainBinding.fab1.startAnimation(FabClose);
                    activityMainBinding.fab1.setClickable(false);

                    //fab2
                    activityMainBinding.fab2Lyt.startAnimation(FabClose);
                    activityMainBinding.fab2Lyt.setVisibility(View.GONE);
                    activityMainBinding.fab2.startAnimation(FabClose);
                    activityMainBinding.fab2.setClickable(false);

                    //main fab
                    //rotating main fab so that it should give close like view.
                    activityMainBinding.floatingActionButton.startAnimation(FabRantiClokwise);

                    isOpen = false;
                }else{
                    //fab1
                    activityMainBinding.fab1.startAnimation(FabOpen);
                    activityMainBinding.fab1Lyt.startAnimation(FabOpen);
                    activityMainBinding.fab1Lyt.setVisibility(View.VISIBLE);
                    activityMainBinding.fab1.setClickable(true);

                    //fab2
                    activityMainBinding.fab2Lyt.startAnimation(FabOpen);
                    activityMainBinding.fab2Lyt.setVisibility(View.VISIBLE);
                    activityMainBinding.fab2.startAnimation(FabOpen);
                    activityMainBinding.fab2.setClickable(true);

                    //main fab
                    //rotating main fab so that it should give open like view.
                    activityMainBinding.floatingActionButton.startAnimation(FabRClockwise);

                    isOpen = true;

                }
            }
        });



    }
}
