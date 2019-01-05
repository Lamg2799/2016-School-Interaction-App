package com.example.steam.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CommunicationClass extends AppCompatActivity {
    EditText rmnumber;
    EditText problem;
    EditText fullname;
    EditText urgency;
    Button submitproblem;
    Button chkfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_class);

        chkfeedback = (Button)findViewById(R.id.chkfeedback);
        rmnumber = (EditText)findViewById(R.id.roomnumber);
        problem = (EditText)findViewById(R.id.problem);
        fullname = (EditText)findViewById(R.id.fullname);
        urgency = (EditText)findViewById(R.id.urgency);
        submitproblem = (Button)findViewById(R.id.submitproblem);
    }
    public static boolean isInteger(String rmnumber1) {
        try {
            int a = Integer.parseInt(rmnumber1);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

    }
    public void writeMessage(View view) {
        String rmnumber1 = rmnumber.getText().toString();
        String problem1 = problem.getText().toString();
        String fullname1 = fullname.getText().toString();
        String urgency1 = urgency.getText().toString();
        String placeholder = "---------------------------------------------------------------------------";

       boolean isvalid = isInteger(rmnumber1);
       if(isvalid==false)
       {
           Toast.makeText(getApplicationContext(),"Class Number is Invalid",Toast.LENGTH_SHORT).show();
       }else if(TextUtils.isEmpty(problem1) || TextUtils.isEmpty(fullname1) || TextUtils.isEmpty(urgency1))
        {
            Toast.makeText(getApplicationContext(),"One or more of the Required Fields Are Empty",Toast.LENGTH_SHORT).show();
        }else if((!urgency1.equals("ASAP")) && (!urgency1.equalsIgnoreCase("whenever possible")))
        {
            Toast.makeText(getApplicationContext(),"Urgency must be set to 'ASAP' or 'whenever possible'",Toast.LENGTH_SHORT).show();
        }
         else {

            try {
                InputStream fileInputStream = getResources().getAssets().open("project.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line;

                int count = 0;

                while((line = br.readLine()) != null)
                {
                    if(line.equals("---------------------------------------------------------------------------"))
                    {
                       count++;
                    }

                }
                String countfornext = "Problem "+(count+1) + ":";
                String seperator = System.getProperty("line.separator");
                String fullnamereal = "Full Name: " + fullname1;
                String rmnumberreal = "Room Number: " + rmnumber1;
                String problemreal = "Problem: " + problem1;
                String urgencyreal = "Urgency: " + urgency1;

                FileOutputStream fileOutputStream = openFileOutput("project.txt", MODE_APPEND);
                fileOutputStream.write(seperator.getBytes());
                fileOutputStream.write(countfornext.getBytes());
                fileOutputStream.write(seperator.getBytes());
                fileOutputStream.write(fullnamereal.getBytes());
                fileOutputStream.write(seperator.getBytes());
                fileOutputStream.write(rmnumberreal.getBytes());
                fileOutputStream.write(seperator.getBytes());
                fileOutputStream.write(problemreal.getBytes());
                fileOutputStream.write(seperator.getBytes());
                fileOutputStream.write(urgencyreal.getBytes());
                fileOutputStream.write(seperator.getBytes());
                fileOutputStream.write(placeholder.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(), "Your Problem Has Been Submitted Succesfully", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent intent3 = new Intent(CommunicationClass.this, MainActivity.class);
            startActivity(intent3);
        }
    }
    public void checkfeedback (View view) {
        Intent intent4 = new Intent(CommunicationClass.this, checkfeedback.class);
        startActivity(intent4);
    }












}
