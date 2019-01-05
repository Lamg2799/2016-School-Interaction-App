package com.example.steam.myapplication;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class highlevelstaff extends AppCompatActivity {

    Button HLSbutton;
    int whichclass;
    //TO RUN APP ON A PHONE GO TO DEVELOPER SETTINGS AND ENABLE USB DEBUGGING OR WONT WORK
    private GestureDetectorCompat gestureObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlevelstaff);
        final MainActivity main = new MainActivity();
        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
//learngesture is class file

        HLSbutton = (Button) findViewById(R.id.HLSbutton);
        HLSbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                whichclass = main.HighLevel();
                startActivity(new Intent(highlevelstaff.this, login.class));
            }


        });
    }
        @Override
        public boolean onTouchEvent(MotionEvent event) {

            this.gestureObject.onTouchEvent(event);
            return super.onTouchEvent(event);


        }

        //need gesture object class which is after
        class LearnGesture extends GestureDetector.SimpleOnGestureListener{
//SimpleOnGestureListener listens for what you want to do and how

            @Override
            public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float VelocityY){


                if(event2.getX() > event1.getX()){
//what you want to do with gesture is put here
                    // left to right swipe
                    Intent intentH = new Intent(highlevelstaff.this, MainActivity.class);
                    finish();
                    startActivity(intentH);


                }else if(event1.getX() > event2.getX()){

//right to left swipe
                    Intent intentHLS = new Intent(highlevelstaff.this, MainActivity.class);
                    finish();
                    startActivity(intentHLS);


                }
                return true;

            }

        }



    }

