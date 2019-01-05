package com.example.steam.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.steam.myapplication.R.styleable.View;

public class delete extends AppCompatActivity {
    EditText deleteedit;
    Button buttondelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteedit = (EditText)findViewById(R.id.deleteedit);
        buttondelete = (Button)findViewById(R.id.buttondelete);

        buttondelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    InputStream fileInputStream = getResources().getAssets().open("project.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line;

                    int count = 0;
                    int count2=0;
                    while ((line = br.readLine()) != null) {
                        while((line = br.readLine()) !="---------------------------------------------------------------------------"){
                            count2++;
                        }
                        if (line.equals("---------------------------------------------------------------------------")) {
                            count++;
                        }

                    }


                    String delete = deleteedit.getText().toString();
                    int finaldelete = 0;
                    try {
                        finaldelete = Integer.parseInt(delete);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid Character, Number Required", Toast.LENGTH_SHORT).show();
                    }
                    if (finaldelete < 1) {
                        Toast.makeText(getApplicationContext(), "Your Number Is Invalid", Toast.LENGTH_SHORT).show();
                    } else if (finaldelete > count) {
                        Toast.makeText(getApplicationContext(), "There Is No Problem Associated With This Number", Toast.LENGTH_SHORT).show();

                    } else {


                        int wheretodeletetop = (finaldelete - 1) * 12 + 1;
                        int wheretodeletebot = wheretodeletetop + 12;


                        File tmp = File.createTempFile("tmp", "");

                        BufferedReader bReader = new BufferedReader(new FileReader("project.txt"));
                        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));

                        for (int i = 0; i < (count2+wheretodeletetop); i++){
                            bw.write(String.format("%s%n", bReader.readLine()));}
                        for (int y = 0; y <= (wheretodeletebot); y++){
                            bReader.readLine();
                    }
                        String l;
                        while (null != (l = bReader.readLine()))
                            bw.write(String.format("%s%n", l));

                        br.close();
                        bw.close();
                        bReader.close();
                        File oldFile = new File("project.txt");
                        if (oldFile.delete())
                            tmp.renameTo(oldFile);


                        Toast.makeText(getApplicationContext(), "Delete Successful", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(delete.this, highlevelinfo.class);
                        startActivity(intent3);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }}




















