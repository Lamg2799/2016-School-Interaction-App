package com.example.steam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;


public class Chat extends AppCompatActivity {
    EditText message;
    ImageButton send;
    TextView readtextfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        message = (EditText) findViewById(R.id.enter);
        send = (ImageButton) findViewById(R.id.sendIcon);
        readtextfile = (TextView) findViewById(R.id.readtextfile1);

    }
    public void sendMessage(View view) {

        String send1 = message.getText().toString();


       if(send1.isEmpty())
       {
           Toast.makeText(getApplicationContext(),"The Message Field Is Empty",Toast.LENGTH_SHORT).show();
       }else {
           try {
               FileInputStream fileInputStream = openFileInput("project3.txt");
               InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
               BufferedReader br = new BufferedReader(inputStreamReader);
               String Message;
               StringBuffer stringBuffer = new StringBuffer();
               String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

               while ((Message = br.readLine()) != null) {
                   stringBuffer.append(Message + "\n" );
               }
               readtextfile.setText(stringBuffer.toString());
               readtextfile.setVisibility(View.VISIBLE);
               readtextfile.setMovementMethod(new ScrollingMovementMethod());

               String seperator = System.getProperty("line.separator");


               FileOutputStream fileOutputStream = openFileOutput("project3.txt", MODE_APPEND);

               fileOutputStream.write(seperator.getBytes());
               fileOutputStream.write(currentDateTimeString.getBytes());
               fileOutputStream.write(send1.getBytes());
               fileOutputStream.close();


               while ((Message = br.readLine()) != null) {
                   stringBuffer.append(Message + "\n" );
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
       }}






























