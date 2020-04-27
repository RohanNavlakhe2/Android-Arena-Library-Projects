package com.example.facebookshimmerdemo

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
//First Add the dependency for shimmer from the app level gradle
    //Now You will make the the layout you want to behave as placeholder of original content while loading the
   //original content.Check the activity_main.xml

  //Now inside MainActivity we will start shimmer while loading the content and stop shimmer after
  //the successful load of the data.


class MainActivity : AppCompatActivity() {

    private lateinit var shimmer:ShimmerFrameLayout
    private lateinit var originalView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shimmer=findViewById(R.id.shimmer)
        originalView=findViewById(R.id.includeOriginalView)

        //call this method while loading the content (i.e. Network Call)
            //For the example sake I'm calling this method initially
         showShimmer()
          Handler().postDelayed({
              //call this method  After Successful Network Response
              //For the example sake I'm calling this method after 5 seconds of the showShimmer() method.
              hideShimmer()
          },5000)
    }

    private fun showShimmer()
    {
        //making shimmer layout visible and original content view gone and finally start the shimmer effect
        shimmer.visibility=View.VISIBLE
        originalView.visibility=View.GONE
        shimmer.startShimmer()
    }

    private fun hideShimmer()
    {
        //making shimmer layout gone and original content view visible and finally stop the shimmer effect
        shimmer.visibility=View.GONE
        originalView.visibility=View.VISIBLE
        shimmer.stopShimmer()
    }
}
