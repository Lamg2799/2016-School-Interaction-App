package com.example.steam.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.button1;
import static com.example.steam.myapplication.MainActivity.whichclass;

import android.widget.Toast;
public class login extends AppCompatActivity {
Button button2;
  EditText username;
    EditText password;
    String username1;
    String passwordString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button2 = (Button) findViewById(R.id.button2);
        username = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.passwordField);


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                username1 = username.getText().toString();
                passwordString = password.getText().toString();
                if (username1.equals("LukeG") && passwordString.equals("luke") && whichclass == 1) {
                    goToTeachersLoggedIn();
                } else if (username1.equals("LukeGG") && passwordString.equals("lukee") && whichclass == 2) {
                    goToHighLevel();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect Username or Password, Or On Wrong Login Page",
                            Toast.LENGTH_SHORT).show();

                }
            }







    });
    }
    public void goToTeachersLoggedIn(){
        startActivity(new Intent(login.this, CommunicationClass.class));
    }
    public void goToHighLevel(){
        startActivity(new Intent(login.this, highlevelinfo.class));
    }

}
