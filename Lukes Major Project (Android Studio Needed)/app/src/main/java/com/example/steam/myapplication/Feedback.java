package com.example.steam.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Feedback extends AppCompatActivity {
    EditText givefeedback;
    Button submit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submit2 = (Button) findViewById(R.id.submit2);
        givefeedback = (EditText) findViewById(R.id.givefeedback);

        final String feedbackString = givefeedback.getText().toString();
        submit2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
try{
    String seperator = System.getProperty("line.separator");

    FileOutputStream fileOutputStream = openFileOutput("feedback.txt", MODE_APPEND);
    fileOutputStream.write(feedbackString.getBytes());
    fileOutputStream.write(seperator.getBytes());
    fileOutputStream.close();

    Toast.makeText(getApplicationContext(), "Feedback Submitted Succesfully", Toast.LENGTH_SHORT).show();

    startActivity(new Intent(Feedback.this, MainActivity.class));
}catch(IOException e){
    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
}


    }
        });


    }
}

