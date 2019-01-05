package com.example.steam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class checkfeedback extends AppCompatActivity {
    TextView readtextfile2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfeedback);


        readtextfile2 = (TextView) findViewById(R.id.readtextfile2);
        readtextfile2.setVisibility(View.GONE);


        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("feedback.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((Message = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(Message + "\n");
            }
            readtextfile2.setText(stringBuffer.toString());
            readtextfile2.setVisibility(View.VISIBLE);
            readtextfile2.setMovementMethod(new ScrollingMovementMethod());

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
