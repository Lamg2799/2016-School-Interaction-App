package com.example.steam.myapplication;

import android.content.Intent;
import android.gesture.Gesture;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    Button button1;
//TO RUN APP ON A PHONE GO TO DEVELOPER SETTINGS AND ENABLE USB DEBUGGING OR WONT WORK
    private GestureDetectorCompat gestureObject;
     static int whichclass = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
//learngesture is class file



        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                whichclass = 1;
                startActivity(new Intent(MainActivity.this, login.class));
            }


        });

}
         int HighLevel(){

             whichclass = 2;
             return whichclass;

         }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);


}
/////////////////////////////////////////////////////////////////////////////////////////////////////
//need gesture object class which is after
class LearnGesture extends GestureDetector.SimpleOnGestureListener{
//SimpleOnGestureListener listens for what you want to do and how

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float VelocityY){


        if(event2.getX() > event1.getX()){
//what you want to do with gesture is put here
            // left to right swipe
Intent intent = new Intent(MainActivity.this, highlevelstaff.class);
             finish();
            startActivity(intent);


        }else if(event1.getX() > event2.getX()){

//right to left swipe
            Intent intent1 = new Intent(MainActivity.this, highlevelstaff.class);
            finish();
            startActivity(intent1);


        }
        return true;

    }

}
////////////////////////////////////////////////////////////////////////////////////////////////////
}


