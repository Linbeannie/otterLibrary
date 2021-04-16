package com.example.otterlibrary;
/*
    Title: CreateAccount.java
    Abstract: An activity to create an account if there is not a duplicate username
    Email: mmacaulay@csumb.edu
    Date: 12.17.2020
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.util.List;

public class CreateAccount extends AppCompatActivity{

    otterLibraryDb otterDb;

    EditText createPass_edittext, createuser_edittext;

    Button accountCreate_btn;

    String sUser, sPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createPass_edittext = (EditText) findViewById(R.id.createPass_edittext);
        createuser_edittext = (EditText) findViewById(R.id.createuser_edittext);
        accountCreate_btn = (Button)findViewById(R.id.accountCreate_btn);

        accountCreate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dupCount = 0;
                int createCount = 0;
                if(createPass_edittext.getText().toString().isEmpty() || createuser_edittext.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();

                } else if (otterDb.userDao().usernameExists(createuser_edittext.getText().toString())){

                    Toast.makeText(getApplicationContext(),"Duplicate Username. Enter a new username and password to create account.", Toast.LENGTH_SHORT).show();

                } else {

                    sUser = createPass_edittext.getText().toString().trim();
                    sPass = createPass_edittext.getText().toString().trim();

                    otterDb = otterLibraryDb.getInstance(getApplicationContext());
                    User user = new User(sUser, sPass);
                    otterDb.userDao().insertUser(user);

                    createuser_edittext.setText("");
                    createPass_edittext.setText("");

                }
            }
        });
    }


}