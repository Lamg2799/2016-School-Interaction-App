package com.example.steam.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class highlevelinfo extends AppCompatActivity {
    TextView readtextfile;
    Button delete;
    Button chat;
    Button feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlevelinfo);

        feedback = (Button) findViewById(R.id.feedback);
        readtextfile = (TextView)findViewById(R.id.readtextfile);
        readtextfile.setVisibility(View.GONE);
        chat = (Button) findViewById(R.id.chat);
        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(highlevelinfo.this, delete.class));
            }


        });
        chat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(highlevelinfo.this, Chat.class));
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(highlevelinfo.this, Feedback.class));
            }


        });

        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("project.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((Message = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(Message + "\n");
            }
            readtextfile.setText(stringBuffer.toString());
            readtextfile.setVisibility(View.VISIBLE);
            readtextfile.setMovementMethod(new ScrollingMovementMethod());

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
